package com.reymer.ninjagold.controllers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
	@RequestMapping("/gold")
	public String index(HttpSession session, Model model) {
		if(session.getAttribute("gold") == null) {
            session.setAttribute("gold", 0);
        }
		if (session.getAttribute("activities") == null) {
			session.setAttribute("activities", new ArrayList<String>());
		}
		model.addAttribute("gold", session.getAttribute("gold"));
		model.addAttribute("activities", session.getAttribute("activities"));
		return "index.jsp";
	}
	@RequestMapping(path="/process", method=RequestMethod.POST)
	public String processGold(@RequestParam(value="source") String source, HttpSession session) {
		Integer currentGold = (Integer) session.getAttribute("gold");
		ArrayList<String> currentLogs = (ArrayList<String>) session.getAttribute("activities");
		Random rand = new Random();
		SimpleDateFormat dateFormat = new SimpleDateFormat("MMMM dd YYYY h:mm a");
		String currentDate = dateFormat.format(new Date());
		
		if (source.equals("farm")) {
			int amount = rand.nextInt(11) + 10;
			currentGold += amount;
			currentLogs.add(String.format("You entered a %s and earned %d gold (%s)", source, amount, currentDate));
		} else if (source.equals("cave")) {
			int amount = rand.nextInt(6) + 5;
			currentGold += amount;
			currentLogs.add(String.format("You entered a %s and earned %d gold (%s)", source, amount, currentDate));
		} else if (source.equals("house")) {
			int amount = rand.nextInt(4) + 2;
			currentGold += amount;
			currentLogs.add(String.format("You entered a %s and earned %d gold (%s)", source, amount, currentDate));
		} else if (source.equals("spa")) {
			int amount = rand.nextInt(16) + 5;
			currentGold -= amount;
			currentLogs.add(String.format("You entered a %s and lost %d gold (%s)", source, amount, currentDate));
		} else if (source.equals("casino")) {
			int amount = rand.nextInt(51);
			Random newRand = new Random();
			int r = newRand.nextInt(2);
			if (r == 0) {
				currentGold -= amount;
				currentLogs.add(String.format("You entered a %s and lost %d gold (%s)", source, amount, currentDate));
			} else {
				currentGold += amount;
				currentLogs.add(String.format("You entered a %s and earned %d gold (%s)", source, amount, currentDate));
			}
		}
		
		if (currentGold < -150) {
			return "redirect:/prison";
		}
		session.setAttribute("gold", currentGold);
		session.setAttribute("activities", currentLogs);
		return "redirect:/gold";
	}
	@RequestMapping("/reset")
	public String resetGold(HttpSession session) {
		session.invalidate();
		return "redirect:/gold";
	}
	@RequestMapping("/prison")
	public String sendPrison() {
		return "prison.jsp";
	}
}
