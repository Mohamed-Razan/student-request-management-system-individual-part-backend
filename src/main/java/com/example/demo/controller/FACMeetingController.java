package com.example.demo.controller;



import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.FACMeeting;
import com.example.demo.service.FACMeetingService;

@RestController
@CrossOrigin(origins = "*")
public class FACMeetingController {

	@Autowired
	private FACMeetingService service;
	
	@PostMapping("/postmeeting")
	public FACMeeting postMeeting(@RequestParam Date meetingDate, @RequestParam @DateTimeFormat(pattern = "HH:mm") Date meetingTime, @RequestParam String location) {
		return service.postMeeting(meetingDate, meetingTime, location);
	}
}
