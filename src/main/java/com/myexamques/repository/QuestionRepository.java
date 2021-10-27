package com.myexamques.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;


import com.myexamques.entity.Question;

@Transactional
public interface QuestionRepository extends JpaRepository<Question,Integer> {

}

