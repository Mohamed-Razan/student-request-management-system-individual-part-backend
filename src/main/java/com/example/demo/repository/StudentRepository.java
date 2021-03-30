package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Student;


public interface StudentRepository extends JpaRepository<Student, Integer> {
	Optional<Student> findByIndexNo(String indexNo);
	Boolean existsByIndexNo(String indexNo);
}
