package com.reymer.roster.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.reymer.roster.models.Contact;
import com.reymer.roster.models.Student;
import com.reymer.roster.repositories.ContactRepository;
import com.reymer.roster.repositories.StudentRepository;

@Service
public class RosterService {
	private final StudentRepository studentRepo;
	private final ContactRepository contactRepo;
	public RosterService(StudentRepository studentRepo, ContactRepository contactRepo) {
		this.studentRepo = studentRepo;
		this.contactRepo = contactRepo;
	}
	
	public List<Student> getAllStudents() {
		return this.studentRepo.findAll();
	}
	public List<Student> getAllStudentsWithoutContact() {
		return this.studentRepo.findByContactIdIsNull();
	}
	public Student getSingleStudent(Long id) {
		return this.studentRepo.findById(id).orElse(null);
	}
	public List<Contact> getAllContacts() {
		return this.contactRepo.findAll();
	}
	public Student createStudent(Student student) {
		return this.studentRepo.save(student);
	}
	public Contact createContact(Contact contact) {
		return this.contactRepo.save(contact);
	}
}
