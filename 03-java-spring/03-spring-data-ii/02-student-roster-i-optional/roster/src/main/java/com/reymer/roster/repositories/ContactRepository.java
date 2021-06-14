package com.reymer.roster.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.reymer.roster.models.Contact;

@Repository
public interface ContactRepository extends CrudRepository<Contact, Long> {
	List<Contact> findAll();
}
