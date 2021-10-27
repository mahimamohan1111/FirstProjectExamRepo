package com.myexamques.service;

import com.myexamques.entity.Question;
import com.myexamques.repository.QuestionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {
    @Autowired
    private QuestionRepository repository;

    public Question saveQuestion(Question question) {
        return repository.save(question);
    }

    public List<Question> saveQuestions(List<Question> question) {
        return repository.saveAll(question);
    }

    public List<Question> getQuestions() {
    	System.out.println("reading from service");
      return repository.findAll();
    }

    public Question getQuestionById(int id) {
    	System.out.println("Getting Ques By ID "+id);
      return repository.findById(id).orElse(null);
    }

//    public Question getProductByName(String name) {
//        return repository.findByName(name);
//    }

    public String deleteQuestion(int id) {
        repository.deleteById(id);
        return "question removed !! " + id;
    }

//    public Question updateProduct(Question product) {
//        Question existingProduct = repository.findById(product.getId()).orElse(null);
//        existingProduct.setName(product.getName());
//        existingProduct.setQuantity(product.getQuantity());
//        existingProduct.setPrice(product.getPrice());
//        return repository.save(existingProduct);
//    }


}
