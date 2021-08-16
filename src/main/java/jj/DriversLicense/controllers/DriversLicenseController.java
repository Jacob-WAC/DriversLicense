package jj.DriversLicense.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jj.DriversLicense.models.License;
import jj.DriversLicense.models.Person;
import jj.DriversLicense.services.DriversLicenseService;




@Controller
public class DriversLicenseController {
	private final DriversLicenseService service;
	public DriversLicenseController(DriversLicenseService serv) {
		this.service = serv;
	}
	@RequestMapping("/")
	public String Index(@ModelAttribute("person") Person person) {
		
		return "/driverslicense/newperson.jsp";
	}
	@RequestMapping(value="/create", method=RequestMethod.POST)
	public String CreatePerson(@Valid @ModelAttribute("person") Person person, BindingResult result) {
		if(result.hasErrors() ) {
			return "/driverslicense/newperson.jsp";
		}
		service.createPerson(person);
		return "redirect:/licenses/new";
	}
	
	@RequestMapping("/{id}")
	public String ShowPerson(@PathVariable("id") Long id, Model model) {
		Person person = service.getPerson(id);
		model.addAttribute("person", service.getPerson(id));
		System.out.println(person.getLicense());
		return "/driverslicense/show.jsp";
	}

	
	@RequestMapping("/licenses/new")
	public String NewLicense(@ModelAttribute("license") License lic, Model model) {
		List<Person> unlicensed = service.getUnlicensedPeople();
		model.addAttribute("persons", unlicensed);
		return "/driverslicense/newlicense.jsp";
	}
	@RequestMapping(value = "/licenses", method=RequestMethod.POST)
	public String CreateLicense(@Valid @ModelAttribute("license") License license, BindingResult result) {
		if(result.hasErrors())
			return "/driverslicense/newlicense.jsp";
		service.createLicense(license);
	
		
		return "redirect:/";
	}
}