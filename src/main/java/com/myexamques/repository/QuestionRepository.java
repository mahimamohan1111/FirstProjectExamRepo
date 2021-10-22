package com.myexamques.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.myexamques.entity.Question;

@Transactional
public interface QuestionRepository extends JpaRepository<Question,Integer> {

}

