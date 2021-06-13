package com.reymer.relationships.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.reymer.relationships.models.License;
import com.reymer.relationships.models.Person;
import com.reymer.relationships.repositories.LicenseRepository;
import com.reymer.relationships.repositories.PersonRepository;

@Service
public class DriverService {
	private final PersonRepository personRepo;
	private final LicenseRepository licenseRepo;
	public DriverService(PersonRepository personRepo, LicenseRepository licenseRepo) {
		this.personRepo = personRepo;
		this.licenseRepo = licenseRepo;
	}
	public List<Person> getAllPeople() {
		return this.personRepo.findAll();
	}
	public List<Person> getUnlicensedPeople() {
		return this.personRepo.findByLicenseIdIsNull();
	}
	public Person getSinglePerson(Long id) {
		return this.personRepo.findById(id).orElse(null);
	}
	public Person createPerson(Person person) {
		return this.personRepo.save(person);
	}
	public int createLicenseNumber() {
		License license = this.licenseRepo.findTopByOrderByNumberDesc();
		if(license == null)
			return 1;
		int largestNumber = license.getNumber();
		largestNumber++;
		return (largestNumber);
	}	
	public License createLicense(License license) {
		license.setNumber(this.createLicenseNumber());
		return this.licenseRepo.save(license);
	}
}
