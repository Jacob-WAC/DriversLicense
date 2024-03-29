package jj.DriversLicense.repositories;

import java.util.List;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import jj.DriversLicense.models.License;




@Repository
public interface LicenseRepository extends CrudRepository<License, Long>{
    
	public List<License> findAll();
	public License findTopByOrderByNumberDesc();
    
 
    
  

    
}