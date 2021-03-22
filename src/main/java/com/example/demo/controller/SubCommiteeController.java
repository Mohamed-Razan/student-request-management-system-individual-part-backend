package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.SubCommitee;
import com.example.demo.service.SubCommiteeService;

@RestController
public class SubCommiteeController {

	@Autowired
	private SubCommiteeService service;
	
	@PostMapping("/apppointsubcommitee")
	public SubCommitee postSubCommitee(String purpose, String discripition1, int leaderId, int facMemberId[]) {
		return service.postSubCommitee(purpose, discripition1, leaderId, facMemberId);
	}
}
