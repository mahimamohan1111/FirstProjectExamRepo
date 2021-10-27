package com.myexamques.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myexamques.entity.Question;
import com.myexamques.service.QuestionService;

import lombok.extern.slf4j.Slf4j;


@RestController
@RequestMapping(value = "/questions")
@Slf4j
public class QuesController {

	@Autowired
	private QuestionService service;

	@PostMapping("")
	public List<Question> addQuestions(@RequestBody List<Question> question) {
		return service.saveQuestions(question);
	}

	@GetMapping("")
	public List<Question> findAllQuestions() {
    log.debug("IS it reaching here?");
		return service.getQuestions();
	}

	@GetMapping("/{id}")
	public Question findQuestionById(@PathVariable int id) {
		log.debug("My ID is: {}", id);
		log.debug("getQuestionById response: {}", service.getQuestionById(id));
		return service.getQuestionById(id);
	}

	@DeleteMapping("/{id}")
	public String deleteQuestion(@PathVariable int id) {
		return service.deleteQuestion(id);
	}

}
