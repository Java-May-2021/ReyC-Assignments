package com.reymer.events.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.reymer.events.models.Event;
import com.reymer.events.models.User;
import com.reymer.events.services.EventService;
import com.reymer.events.services.MessageService;
import com.reymer.events.services.UserService;

@Controller
public class EventController {
	private final EventService eventService;
	private final MessageService messageService;
	private final UserService userService;
	
	public EventController(EventService eventService, MessageService messageService, UserService userService) {
		this.eventService = eventService;
		this.messageService = messageService;
		this.userService = userService;
	}
	
	@GetMapping("/events")
	public String dashboard(@ModelAttribute("event") Event event, Model model, HttpSession session) {
		Long userId = (Long) session.getAttribute("userId");
		if(userId == null) {
			return "redirect:/";
		}
		User user = this.userService.findUserById(userId);
		String[] states = {"AL","AK","AR","AZ","CA","CO","CT","DC","DE","FL","GA","HI",
        		"IA","ID","IL","IN","KS","KY","LA","MA","ME", "MD","MI","MN","MO","MS",
        		"MT","NC","ND","NE","NE","NH","NJ","NM","NV","OH","OK","OR","PA","RI",
        		"SC","SD","TN","TX","UT","VT","VA","WA","WI","WV","WY"};
		model.addAttribute("user", user);
		model.addAttribute("states", states);
		model.addAttribute("userStates", this.eventService.findAllEventsInState(user.getState()));
		model.addAttribute("otherStates", this.eventService.findAllEventsNotInState(user.getState()));
		return "events/dashboard.jsp";
	}
	
	@PostMapping("/events")
	public String createEvent(@Valid @ModelAttribute("event") Event event, BindingResult result, Model model, HttpSession session) {
		if(result.hasErrors()) {
			Long userId = (Long) session.getAttribute("userId");
			User user = this.userService.findUserById(userId);
			String[] states = {"AL","AK","AR","AZ","CA","CO","CT","DC","DE","FL","GA","HI",
	        		"IA","ID","IL","IN","KS","KY","LA","MA","ME", "MD","MI","MN","MO","MS",
	        		"MT","NC","ND","NE","NE","NH","NJ","NM","NV","OH","OK","OR","PA","RI",
	        		"SC","SD","TN","TX","UT","VT","VA","WA","WI","WV","WY"};
			model.addAttribute("user", user);
			model.addAttribute("states", states);
			model.addAttribute("userStates", this.eventService.findAllEventsInState(user.getState()));
			model.addAttribute("otherStates", this.eventService.findAllEventsNotInState(user.getState()));
			return "events/dashboard.jsp";
		}
		this.eventService.createEvent(event);
		return "redirect:/events";
	}
	
	@GetMapping("/events/{id}")
	public String showEvent(@PathVariable("id") Long id, Model model, HttpSession session) {
		Long userId = (Long) session.getAttribute("userId");
		User user = this.userService.findUserById(userId);
		Event event = this.eventService.findEventById(id);
		model.addAttribute("user", user);
		model.addAttribute("event", event);
		return "events/showEvent.jsp";
	}
	
	@PostMapping("/events/{id}/message")
	public String createMessage(@PathVariable("id") Long id, @RequestParam("content") String content, HttpSession session, RedirectAttributes redirectAttribute) {
		if(content.equals("")) {
			redirectAttribute.addFlashAttribute("error", "Comment should not be empty.");
			return "redirect:/events/" + id;
		}
		Long userId = (Long) session.getAttribute("userId");
		User user = this.userService.findUserById(userId);
		Event event = this.eventService.findEventById(id);
		this.messageService.comment(user, event, content);
		return "redirect:/events/" + id;
	}
	
	@GetMapping("/events/{id}/edit")
	public String editEvent(@PathVariable("id") Long id, Model model, HttpSession session) {
		Long userId = (Long) session.getAttribute("userId");
		User user = this.userService.findUserById(userId);
		String[] states = {"AL","AK","AR","AZ","CA","CO","CT","DC","DE","FL","GA","HI",
        		"IA","ID","IL","IN","KS","KY","LA","MA","ME", "MD","MI","MN","MO","MS",
        		"MT","NC","ND","NE","NE","NH","NJ","NM","NV","OH","OK","OR","PA","RI",
        		"SC","SD","TN","TX","UT","VT","VA","WA","WI","WV","WY"};
		Event event = this.eventService.findEventById(id);
		model.addAttribute("event", event);
		model.addAttribute("user", user);
		model.addAttribute("states", states);
		return "events/editEvent.jsp";
	}
	
	@PostMapping("/events/{id}/edit")
	public String updateEvent(@Valid @ModelAttribute("event") Event event, BindingResult result, @PathVariable("id") Long id, Model model, HttpSession session) {
		if(result.hasErrors()) {
			Long userId = (Long) session.getAttribute("userId");
			User user = this.userService.findUserById(userId);
			String[] states = {"AL","AK","AR","AZ","CA","CO","CT","DC","DE","FL","GA","HI",
	        		"IA","ID","IL","IN","KS","KY","LA","MA","ME", "MD","MI","MN","MO","MS",
	        		"MT","NC","ND","NE","NE","NH","NJ","NM","NV","OH","OK","OR","PA","RI",
	        		"SC","SD","TN","TX","UT","VT","VA","WA","WI","WV","WY"};
			model.addAttribute("user", user);
			model.addAttribute("states", states);
			model.addAttribute("event", event);
			return "events/editEvent.jsp";
		}
		this.eventService.updateEvent(event);
		return "redirect:/events";
	}
	
	@GetMapping("/events/{id}/delete")
	public String deleteEvent(@PathVariable("id") Long id) {
		this.eventService.deleteEvent(id);
		return "redirect:/events";
	}
	
	@GetMapping("/events/{id}/join")
	public String joinEvent(@PathVariable("id") Long id, HttpSession session) {
		Event event = this.eventService.findEventById(id);
		Long userId = (Long) session.getAttribute("userId");
		User user = this.userService.findUserById(userId);
		this.eventService.addUserToEvent(user, event);
		return "redirect:/events";
	}
	
	@GetMapping("/events/{id}/cancel")
	public String cancelEvent(@PathVariable("id") Long id, HttpSession session) {
		Event event = this.eventService.findEventById(id);
		Long userId = (Long) session.getAttribute("userId");
		User user = this.userService.findUserById(userId);
		this.eventService.removeUserFromEvent(user, event);
		return "redirect:/events";
	}	
}
