package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Request;
import com.example.demo.entity.Student;

public interface RequestRepository extends JpaRepository<Request, Integer> {

	List<Request> findByStd(Student std);
}
