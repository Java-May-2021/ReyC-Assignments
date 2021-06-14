package com.reymer.roster.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.reymer.roster.models.Contact;
import com.reymer.roster.models.Student;
import com.reymer.roster.services.RosterService;

@Controller
public class RosterController {
	private final RosterService rosterService;
	public RosterController(RosterService rosterService) {
		this.rosterService = rosterService;
	}
	@GetMapping("/students")
	public String studentIndex(Model model) {
		List<Student> students = this.rosterService.getAllStudents();
		model.addAttribute("students", students);
		return "students/showAllStudents.jsp";
	}
	@GetMapping("/students/new")
	public String newStudent(@ModelAttribute("student") Student student) {
		return "students/newStudent.jsp";
	}
	@PostMapping("/students/new")
	public String createStudent(@Valid @ModelAttribute("student") Student student, BindingResult result) {
		if(result.hasErrors()) {
			return "students/newStudent.jsp";
		} else {
			this.rosterService.createStudent(student);
			return "redirect:/students";
		}
	}
	@GetMapping("/contacts/new")
	public String newContact(@ModelAttribute("contact") Contact contact, Model model) {
		List<Student> students = this.rosterService.getAllStudentsWithoutContact();
		model.addAttribute("students", students);
		return "contacts/newContact.jsp";
	}
	@PostMapping("/contacts/new")
	public String createContact(@Valid @ModelAttribute("contact") Contact contact, BindingResult result) {
		if(result.hasErrors()) {
			return "contacts/newContact.jsp";
		} else {
			this.rosterService.createContact(contact);
			return "redirect:/students";
		}
	}
}
