package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;

@RestController
@CrossOrigin(origins = "*")
public class StudentController {

	@Autowired
	private StudentService service;
	
	@PostMapping("/regstudent")
	public Student regStudent(@RequestBody Student std) {
		return service.regStudent(std);
	}
	
}
