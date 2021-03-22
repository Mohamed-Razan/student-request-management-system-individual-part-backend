package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.FACMember;
import com.example.demo.service.FACMemberService;

@RestController
@CrossOrigin(origins = "*")
public class FACMemberController {

	@Autowired
	private FACMemberService service;
	
	@PostMapping("/regfacmember")
	public FACMember postFACMember(@RequestBody FACMember facMember) {
		return service.postFACMember(facMember);
	}
	
	@GetMapping("facmember/{facId}")
	public FACMember FACMember(@PathVariable int facId) {
		return service.getFACMember(facId);
	}
}
