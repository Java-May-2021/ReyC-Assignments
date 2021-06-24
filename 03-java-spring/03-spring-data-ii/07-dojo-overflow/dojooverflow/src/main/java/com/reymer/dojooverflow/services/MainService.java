package com.reymer.dojooverflow.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.reymer.dojooverflow.models.Answer;
import com.reymer.dojooverflow.models.Question;
import com.reymer.dojooverflow.models.Tag;
import com.reymer.dojooverflow.repositories.AnswerRepository;
import com.reymer.dojooverflow.repositories.QuestionRepository;
import com.reymer.dojooverflow.repositories.TagRepository;

@Service
public class MainService {
	private final QuestionRepository quesRepo;
	private final AnswerRepository ansRepo;
	private final TagRepository tagRepo;
	public MainService(QuestionRepository quesRepo, AnswerRepository ansRepo, TagRepository tagRepo) {
		this.quesRepo = quesRepo;
		this.ansRepo = ansRepo;
		this.tagRepo = tagRepo;
	}
	
	//Question
	public List<Question> getAllQuestions() {
		return this.quesRepo.findAll();
	}
	public Question getSingleQuestion(Long id) {
		return this.quesRepo.findById(id).orElse(null);
	}
	public Question createQuestion(Question question) {
		List<Tag> questionsTags = new ArrayList<Tag>();
		for(String subject: question.splitTags()) {
			Tag tag = this.tagRepo.findBySubject(subject.toLowerCase().trim());
			if(tag == null) {
				tag = new Tag(subject);
				this.tagRepo.save(tag);
			}
			if(!questionsTags.contains(tag)) {
				questionsTags.add(tag);
			}
		}
		Question newQuestion = new Question(question.getQuestion(), questionsTags);
		return this.quesRepo.save(newQuestion);
	}
	
	//Answer
	public List<Answer> getAllAnswers() {
		return this.ansRepo.findAll();
	}
	public Answer getSingleAnswer(Long id) {
		return this.ansRepo.findById(id).orElse(null);
	}
	public Answer createAnswer(Answer answer) {
		return this.ansRepo.save(answer);
	}
	public void addAnswerToQuestion(Question question, Answer answer) {
		List<Answer> answers = question.getAnswers();
		answers.add(answer);
		this.ansRepo.save(answer);
	}
	
	//Tag
	public List<Tag> getAllTags() {
		return this.tagRepo.findAll();
	}
}
