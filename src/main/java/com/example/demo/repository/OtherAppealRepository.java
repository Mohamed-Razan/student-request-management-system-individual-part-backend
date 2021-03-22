package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.OtherAppeal;
import com.example.demo.entity.Student;


public interface OtherAppealRepository extends JpaRepository<OtherAppeal, Integer> {

	List<OtherAppeal> findByStd(Student std);
}
