package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Attend;
import com.example.demo.service.AttendService;

@RestController
public class AttendController {

	@Autowired
	private AttendService service;
	
	@PostMapping("/postattend")
	public Attend postAttend(@RequestParam int facMemberId, @RequestParam int facMeetingId, @RequestParam boolean attendence, @RequestParam String apology) {
		
		return service.postAttend(facMemberId, facMeetingId, attendence, apology);
	}
}
