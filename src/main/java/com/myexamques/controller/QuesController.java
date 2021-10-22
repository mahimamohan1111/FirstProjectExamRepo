package com.myexamques.controller;

import com.myexamques.entity.RequestObject;
import com.myexamques.entity.Question;
import com.myexamques.service.QuestionService;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class QuesController {

	@Autowired
	private QuestionService service;



	Logger logger=LoggerFactory.getLogger(QuesController.class);
	

	@PostMapping("/addquestion")
	public Question addQuestion2(@RequestBody RequestObject exam) {
		logger.error("No Error!");
		return service.saveQuestion(exam.getQuestion());
	}


	@PostMapping("/addquestions")
	public List<Question> addQuestions(@RequestBody List<Question> question) {
		return service.saveQuestions(question);
	}

	@GetMapping("/questions")
	public List<Question> findAllQuestions() {
	logger.debug("IS it reaching here?");
		return service.getQuestions();
	}

	@GetMapping("/questionById/{id}")
	public Question findQuestionById(@PathVariable int id) {
		logger.debug("My ID is:"+id);
		logger.debug(" "+service.getQuestionById(id));
		return service.getQuestionById(id);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteQuestion(@PathVariable int id) {
		return service.deleteQuestion(id);
	}

	@RequestMapping("/")
	@ResponseBody
	public String welcome() {
		logger.debug("First Request");
		return "Welcome to My First REST API Example.";
	}
}
