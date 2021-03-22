package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.LeaveRequest;
import com.example.demo.entity.Student;


public interface LeaveRequestRepository extends JpaRepository<LeaveRequest, Integer> {
	
	List<LeaveRequest> findByStd(Student std);
}

