package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Attend;
import com.example.demo.repository.AttendRepository;

@Service
public class AttendService {

	@Autowired
	private AttendRepository repository;
	
	@Autowired
	private FACMemberService facMemberService;
	
	@Autowired
	private FACMeetingService fACMeetingService;
	
	public Attend postAttend(int facMemberId, int facMeetingId, boolean attendence, String apology) {
		
		Attend attend = new Attend(facMemberService.getFACMember(facMemberId), fACMeetingService.getMeeting(facMeetingId), attendence, apology);
		return repository.save(attend);
	}
}
