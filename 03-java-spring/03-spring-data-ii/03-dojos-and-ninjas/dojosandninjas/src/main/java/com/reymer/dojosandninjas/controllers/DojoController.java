package com.reymer.dojosandninjas.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.reymer.dojosandninjas.models.Dojo;
import com.reymer.dojosandninjas.models.Ninja;
import com.reymer.dojosandninjas.services.DojoService;

@Controller
public class DojoController {
	private final DojoService dojoService;
	public DojoController(DojoService dojoService) {
		this.dojoService = dojoService;
	}
	
	@GetMapping("/dojos")
	public String index(Model model) {
		List<Dojo> dojos = this.dojoService.getAllDojo();
		model.addAttribute("dojos", dojos);
		return "index.jsp";	
	}
	@GetMapping("/dojos/new")
	public String newDojo(@ModelAttribute("dojo") Dojo dojo) {
		return "newDojo.jsp";
	}
	@PostMapping("/dojos/new")
	public String createDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
		if(result.hasErrors()) {
			return "newDojo.jsp";
		} else {
			this.dojoService.createDojo(dojo);
			return "redirect:/dojos";
		}
	}
	@GetMapping("/dojos/{id}")
	public String showDojo(@PathVariable("id") Long id, Model model) {
		Dojo dojo = this.dojoService.getSigleDojo(id);
		model.addAttribute("dojo", dojo);
		return "showDojo.jsp";
	}
	@GetMapping("/ninjas/new")
	public String newNinja(@ModelAttribute("ninja") Ninja ninja, Model model) {
		List<Dojo> dojos = this.dojoService.getAllDojo();
		model.addAttribute("dojos", dojos);
		return "newNinja.jsp";
	}
	@PostMapping("/ninjas/new")
	public String createNinja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result) {
		if(result.hasErrors()) {
			return "newNinja.jsp";
		} else {
			this.dojoService.createNinja(ninja);
			return "redirect:/ninjas/new";
		}
	}
}
