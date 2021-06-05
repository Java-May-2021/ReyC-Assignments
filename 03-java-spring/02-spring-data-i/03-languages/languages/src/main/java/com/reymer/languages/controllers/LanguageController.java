package com.reymer.languages.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.reymer.languages.models.Language;
import com.reymer.languages.services.LanguageService;

@Controller
public class LanguageController {
	@Autowired
	private final LanguageService languageService;
    
    public LanguageController(LanguageService languageService) {
        this.languageService = languageService;
    }
    
    @GetMapping("/languages")
    public String dashboard(Model model, @ModelAttribute("language") Language language) {
    	List<Language> languages = this.languageService.getAllLangauges();
    	model.addAttribute("languages",languages);
    	return "dashboard.jsp";
    }
    @PostMapping("/languages")
    public String createLanguage(@Valid @ModelAttribute("language") Language language, BindingResult result) {
        if (result.hasErrors()) {
            return "dashboard.jsp"	;
        } else {
            this.languageService.createLanguage(language);
            return "redirect:/languages";
        }
    }
    @GetMapping("/languages/{id}")
    public String showLanguage(Model model, @PathVariable("id") Long id) {
    	Language language = this.languageService.getSingleLanguage(id);
    	model.addAttribute("language", language);
    	return "showLanguage.jsp";
    }
    @GetMapping("/languages/{id}/edit")
    public String editLanguage(Model model, @PathVariable("id") Long id) {
    	Language language = this.languageService.getSingleLanguage(id);
    	model.addAttribute("language", language);
    	return "editLanguage.jsp";
    }
    @PostMapping("/languages/{id}/edit")
    public String updateLanguage(@PathVariable("id") Long id, @Valid @ModelAttribute("language") Language language, BindingResult result) {
        if (result.hasErrors()) {
            return "editLanguage.jsp";
        } else {
            this.languageService.updateLanguage(language);
            return "redirect:/languages";
        }
    }
    @GetMapping("languages/{id}/delete")
    public String deleteLanguage(@PathVariable("id") Long id) {
    	this.languageService.deleteLanguage(id);
    	return "redirect:/languages";
    }
    
}
