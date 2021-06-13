package com.reymer.dojosandninjas.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.reymer.dojosandninjas.models.Dojo;
import com.reymer.dojosandninjas.models.Ninja;
import com.reymer.dojosandninjas.repositories.DojoRepository;
import com.reymer.dojosandninjas.repositories.NinjaRepository;

@Service
public class DojoService {
	private final DojoRepository dojoRepo;
	private final NinjaRepository ninjaRepo;
	public DojoService(DojoRepository dojoRepo, NinjaRepository ninjaRepo) {
		this.dojoRepo = dojoRepo;
		this.ninjaRepo = ninjaRepo;
	}
	
	public List<Dojo> getAllDojo() {
		return this.dojoRepo.findAll();
	}
	public Dojo getSigleDojo(Long id) {
		return this.dojoRepo.findById(id).orElse(null);
	}
	public List<Ninja> getAllNinja() {
		return this.ninjaRepo.findAll();
	}
	public Dojo createDojo(Dojo dojo) {
		return this.dojoRepo.save(dojo);
	}
	public Ninja createNinja(Ninja ninja) {
		return this.ninjaRepo.save(ninja);
	}
}
