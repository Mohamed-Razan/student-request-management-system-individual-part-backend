package com.example.demo.service;



import java.io.IOException;
import java.util.Date;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.FACMeeting;
import com.example.demo.repository.FACMeetingRepository;

@Service
public class FACMeetingService {

	@Autowired
	private FACMeetingRepository repository;
	
	@Autowired
	private MeetingEmailService meetingEmailService;
	
	
	public FACMeeting postMeeting(Date meetingDate, Date meetingTime, String location) {
		
		FACMeeting meeting = new FACMeeting(meetingDate, meetingTime, location);
		
		meetingEmailService.sendEmail("mifmilan@gmail.com", "test project", "topic");
		
		return repository.save(meeting);
	}
	
	public FACMeeting getMeeting(int facMeetingId) {
		return repository.findById(facMeetingId).orElse(null);
	}
}
