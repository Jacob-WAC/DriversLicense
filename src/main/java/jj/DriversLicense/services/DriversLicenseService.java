package jj.DriversLicense.services;

import java.util.List;
import org.springframework.stereotype.Service;

import jj.DriversLicense.models.License;
import jj.DriversLicense.models.Person;
import jj.DriversLicense.repositories.LicenseRepository;
import jj.DriversLicense.repositories.PersonRepository;
@Service
public class DriversLicenseService {
   
    private final PersonRepository PersonRepository;
    private final LicenseRepository LicenseRepository;
    public DriversLicenseService(PersonRepository PersonRepository,LicenseRepository LicenseRepository) {
        this.PersonRepository = PersonRepository;
		this.LicenseRepository = LicenseRepository;
    }
  
    public List<Person> allSongs() {
        return PersonRepository.findAll();
    }

    public Person getPerson(Long id) {
		return PersonRepository.findById(id).orElse(null);
	}
	public List<Person> getPeople() {
		return PersonRepository.findAll();
	}
	public List<Person> getUnlicensedPeople() {
		return PersonRepository.findByLicenseIdIsNull();
	}
	public Person createPerson(Person Person) {
		return PersonRepository.save(Person);
	}
	public License createLicense(License License) {
		License.setNumber(this.generateLicenseNumber());
		return LicenseRepository.save(License);
	}
	public int generateLicenseNumber() {
		License License = LicenseRepository.findTopByOrderByNumberDesc();
		if(License == null)
			return 1;
		int largestNumber = License.getNumber();
		largestNumber++;
		return (largestNumber);
	}
    
    
    
    
}
