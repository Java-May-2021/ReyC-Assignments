package com.reymer.languages.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.reymer.languages.models.Language;
import com.reymer.languages.repositories.LanguageRepository;

@Service
public class LanguageService {
	private final LanguageRepository languageRepo;
	
	public LanguageService(LanguageRepository languageRepo) {
		this.languageRepo = languageRepo;
	}
	public List<Language> getAllLangauges() {
		return this.languageRepo.findAll();
	}
	public Language getSingleLanguage(Long id) {
		return this.languageRepo.findById(id).orElse(null);
	}
	public Language createLanguage(Language newLanguage) {
		return this.languageRepo.save(newLanguage);
	}
	public Language updateLanguage(Language updatedLanguage) {
		return this.languageRepo.save(updatedLanguage);
	}
	public void deleteLanguage(Long id) {
		this.languageRepo.deleteById(id);
	}
}
