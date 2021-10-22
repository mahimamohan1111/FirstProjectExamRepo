package com.myexamques.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myexamques.entity.Option;

public interface OptionRepository extends JpaRepository<Option, Integer> {

}
