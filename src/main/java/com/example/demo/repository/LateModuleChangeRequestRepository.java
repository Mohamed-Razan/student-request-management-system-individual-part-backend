package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.LateModuleChangeRequest;
import com.example.demo.entity.Student;

public interface LateModuleChangeRequestRepository extends JpaRepository<LateModuleChangeRequest, Integer> {

	List<LateModuleChangeRequest> findByStd(Student std);
}
