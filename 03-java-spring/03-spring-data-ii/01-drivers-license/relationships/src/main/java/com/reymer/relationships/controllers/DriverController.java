package com.reymer.relationships.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.reymer.relationships.models.License;
import com.reymer.relationships.models.Person;
import com.reymer.relationships.services.DriverService;

@Controller
public class DriverController {
	private final DriverService driverService;
	public DriverController(DriverService driverService) {
		this.driverService = driverService;
	}
	@GetMapping("/persons")
	public String index(Model model) {
		List<Person> people = this.driverService.getAllPeople();
		model.addAttribute("people", people);
		return "index.jsp";
	}
	@GetMapping("/persons/new")
	public String newPerson(@ModelAttribute("person") Person person) {
		return "newPerson.jsp";
	}
	@PostMapping("/persons/new")
	public String CreatePerson(@Valid @ModelAttribute("person") Person person, BindingResult result) {
		if(result.hasErrors() ) {
			return "newPerson.jsp";
		} else {
			this.driverService.createPerson(person);
			return "redirect:/persons";
		}
	}@GetMapping("/persons/{id}")
	public String showPerson(@PathVariable("id") Long id, Model model) {
		Person person = this.driverService.getSinglePerson(id);
		model.addAttribute("person", person);
		return "showPerson.jsp";
	}
	@GetMapping("/licenses/new")
	public String newLicense(@ModelAttribute("license") License license, Model model) {
		List<Person> unlicensePeople = this.driverService.getUnlicensedPeople();
		model.addAttribute("people", unlicensePeople);
		return "newLicense.jsp";
	}
	@PostMapping("/licenses/new")
	public String CreateLicense(@Valid @ModelAttribute("license") License license, BindingResult result) {
		if(result.hasErrors() ) {
			return "newLicense.jsp";
		} else {
			this.driverService.createLicense(license);
			return "redirect:/persons";
		}
	}
}