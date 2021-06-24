package com.reymer.dojooverflow.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.reymer.dojooverflow.models.Answer;
import com.reymer.dojooverflow.models.Question;
import com.reymer.dojooverflow.services.MainService;

@Controller
public class MainController {
	private final MainService mainService;
	public MainController(MainService mainService) {
		this.mainService = mainService;
	}
	
	@GetMapping("/questions")
	public String dashboard(Model model) {
		List<Question> questions = this.mainService.getAllQuestions();
		model.addAttribute("questions", questions);
		return "questions/dashboard.jsp";
	}
	@GetMapping("/questions/new")
	public String newQuestion(@ModelAttribute("newQuestion") Question question) {
		return "questions/newQuestion.jsp";
	}
	@PostMapping("/questions/new")
	public String createQuestion(@Valid @ModelAttribute("newQuestion") Question question, BindingResult result) {
		if (result.hasErrors()) {
			return "questions/newQuestion.jsp";
		}
		this.mainService.createQuestion(question);
		return "redirect:/questions";
	}
	@GetMapping("/questions/{id}")
	public String showQuestion(Model model, @ModelAttribute("newAnswer") Answer answer, @PathVariable("id") Long id) {
		Question question = this.mainService.getSingleQuestion(id);
		model.addAttribute("question", question);
		return "questions/showQuestion.jsp";
	}
	@PostMapping("/questions/answers")
	public String createAnswer(@Valid @ModelAttribute("newAnswer") Answer answer, BindingResult result) {
		if (result.hasErrors()) {
			return "questions/showQuestion.jsp";
		}
		Answer newAnswer = this.mainService.createAnswer(answer);
		return "redirect:/questions/" + newAnswer.getQuestion().getId();
	}
}
