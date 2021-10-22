package com.myexamques.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myexamques.entity.Option;
import com.myexamques.entity.Question;
import com.myexamques.repository.OptionRepository;
import com.myexamques.repository.QuestionRepository;


@Service
public class OptionService {
	 @Autowired
	    private OptionRepository repository;

	    public Option saveOption(Option option) {
	        return repository.save(option);
	    }

	    public List<Option> saveOptions(List<Option> option) {
	        return repository.saveAll(option);
	    }

	    public List<Option> getOptions() {
	    	System.out.println("reading from service of Option");
	        return repository.findAll();
	    }

	    public Option getQuestionById(int id) {
	    	System.out.println("Getting Option By ID "+id);
	        return repository.findById(id).orElse(null);
	    }


	    public String deleteQuestion(int id) {
	        repository.deleteById(id);
	        return "question removed !! " + id;
	    }



	}
