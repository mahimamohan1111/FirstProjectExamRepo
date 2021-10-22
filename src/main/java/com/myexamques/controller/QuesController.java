package com.myexamques.controller;

import com.myexamques.entity.RequestObject;
import com.myexamques.entity.Option;
import com.myexamques.entity.Question;
import com.myexamques.service.OptionService;
import com.myexamques.service.QuestionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class QuesController {

    @Autowired
    private QuestionService service;
    
    @Autowired
    private OptionService serviceOpt;


    @PostMapping("/addquestion")
    public Question addQuestion2(@RequestBody RequestObject exam) {
        return service.saveQuestion(exam.getQuestion());
    }

  
    @PostMapping("/addquestions")
    public List<Question> addQuestions(@RequestBody List<Question> question) {
        return service.saveQuestions(question);
    }

    @GetMapping("/questions")
    public List<Question> findAllQuestions() {
    	System.out.println("At controller");
        return service.getQuestions();
    }

    @GetMapping("/questionById/{id}")
    public Question findQuestionById(@PathVariable int id) {
    	System.out.println("My ID is:"+id);
    	System.out.println(service.getQuestionById(id));
        return service.getQuestionById(id);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteQuestion(@PathVariable int id) {
        return service.deleteQuestion(id);
    }
    
    @RequestMapping("/")
    @ResponseBody
    public String welcome() {
    	System.out.println("First Request");
        return "Welcome to My First REST API Example.";
    }
}
