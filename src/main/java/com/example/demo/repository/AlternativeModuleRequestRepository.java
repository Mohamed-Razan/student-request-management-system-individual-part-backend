package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.AlternativeModuleRequest;
import com.example.demo.entity.Student;



public interface AlternativeModuleRequestRepository extends JpaRepository<AlternativeModuleRequest, Integer> {

	List<AlternativeModuleRequest> findByStd(Student std);
}
