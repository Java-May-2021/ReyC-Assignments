package com.reymer.counter.controllers;

import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@RequestMapping("/my_server")
	public String index(HttpSession session) {
		Integer currentCount = (Integer) session.getAttribute("count");
		currentCount++;
		session.setAttribute("count", currentCount);
		return "index.jsp";
	}
	@RequestMapping("/my_server/countPlusTwo")
	public String countPlusTwo(HttpSession session) {
		Integer currentCount = (Integer) session.getAttribute("count");
		currentCount+=2;
		session.setAttribute("count", currentCount);
		return "counterPlusTwo.jsp";
	}
	@RequestMapping("/my_server/counter")
	public String count(HttpSession session, Model model) {
		if (session.getAttribute("count") == null) {
			session.setAttribute("count", 0);
		}
		model.addAttribute("counter", session.getAttribute("count"));
		return "counter.jsp";
	}
	@RequestMapping("/my_server/reset")
	public String resetCount(HttpSession session) {
		session.invalidate();
		return "redirect:/my_server/counter";
	}
}
