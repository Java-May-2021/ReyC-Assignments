package com.reymer.displaydate.controllers;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	@RequestMapping("/date")
	public String showDate(Model model) {
		Date currentDate = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE, 'the' dd 'of' MMMM, yyyy");
		model.addAttribute("currentDate", dateFormat.format(currentDate));
		return "date.jsp";
	}
	
	@RequestMapping("/time")
	public String showTime(Model model) {
		Date currentDate = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("h:mm a");
		model.addAttribute("currentTime", dateFormat.format(currentDate));
		return "time.jsp";
	}
}
