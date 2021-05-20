package com.reymer.routingpractice.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/dojo")
public class DojoController {
	@RequestMapping("")
	public String dojo() {
		return "The dojo is awesome!";
	}	
	@RequestMapping("/{location}")
	public String showLocation(@PathVariable("location") String dojoLocation) {
		switch(dojoLocation) {
		case "burbank":
			return "Burbank Dojo is located in Southern California.";
		case "san-jose":
			return "SJ Dojo is the headquarters.";
		default:
			return "All the dojos are awesome!";
		}
	}
}
