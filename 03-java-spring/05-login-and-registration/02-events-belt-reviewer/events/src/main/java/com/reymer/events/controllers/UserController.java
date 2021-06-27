package com.reymer.events.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.reymer.events.models.User;
import com.reymer.events.services.UserService;
import com.reymer.events.validators.UserValidator;

@Controller
public class UserController {
	private final UserService userService;
	private final UserValidator userValidator;
    
    public UserController(UserService userService, UserValidator userValidator) {
		this.userService = userService;
		this.userValidator = userValidator;
	}
	
    @GetMapping("/")
    public String registerAndLoginForm(@ModelAttribute("user") User user, Model model) {
        String[] states = {"AL","AK","AR","AZ","CA","CO","CT","DC","DE","FL","GA","HI",
        		"IA","ID","IL","IN","KS","KY","LA","MA","ME", "MD","MI","MN","MO","MS",
        		"MT","NC","ND","NE","NE","NH","NJ","NM","NV","OH","OK","OR","PA","RI",
        		"SC","SD","TN","TX","UT","VT","VA","WA","WI","WV","WY"};
        model.addAttribute("states", states);
    	return "users/registerAndLogin.jsp";
    }
    
    @PostMapping("/register")
    public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session, Model model) {
    	this.userValidator.validate(user, result);
    	String[] states = {"AL","AK","AR","AZ","CA","CO","CT","DC","DE","FL","GA","HI",
        		"IA","ID","IL","IN","KS","KY","LA","MA","ME", "MD","MI","MN","MO","MS",
        		"MT","NC","ND","NE","NE","NH","NJ","NM","NV","OH","OK","OR","PA","RI",
        		"SC","SD","TN","TX","UT","VT","VA","WA","WI","WV","WY"};
    	if(result.hasErrors()) {
    		model.addAttribute("states", states);
    		return "users/registerAndLogin.jsp";
    	}
    	User u = this.userService.registerUser(user);
    	session.setAttribute("userId", u.getId());
    	return "redirect:/events";
    }
    
    @PostMapping("/login")
    public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, HttpSession session, RedirectAttributes redirectAttribute) {
    	boolean isAuthenticated = this.userService.authenticateUser(email, password);
    	if(isAuthenticated) {
    		User u = this.userService.findByEmail(email);
    		session.setAttribute("userId", u.getId());
    		return "redirect:/events";
    	} else {
    		redirectAttribute.addFlashAttribute("error", "Invalid Email/Password. Please try again.");
    		return "redirect:/";
    	}
    }
    
    @GetMapping("/logout")
    public String logout(HttpSession session) {
    	session.invalidate();
    	return "redirect:/";
    }
}
