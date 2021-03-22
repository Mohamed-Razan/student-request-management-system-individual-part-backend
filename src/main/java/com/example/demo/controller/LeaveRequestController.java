package com.example.demo.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entity.LeaveRequest;
import com.example.demo.service.LeaveRequestService;

@RestController
@CrossOrigin(origins = "*")
public class LeaveRequestController {

	@Autowired
	private LeaveRequestService service;
	
	@PostMapping("/request/leaverequest")
	public LeaveRequest submitLeaveRequest(@RequestParam int sid, @RequestParam String leaveType, @RequestParam String on, @RequestParam Date from, @RequestParam Date to, 
			@RequestParam int localWeeks, @RequestParam int localDays, @RequestParam int overseasWeeks, @RequestParam int overseasDays, 
			@RequestParam int totalWeeks, @RequestParam int totalDays, @RequestParam int semesterWeeks, @RequestParam int semesterDays,
			@RequestParam int vacationWeeks, @RequestParam int vacationDays, @RequestParam String reason, @RequestParam MultipartFile annex) {
		
		return service.submitLeaveRequest(sid, leaveType, on, from, to, localWeeks, localDays,
				 overseasWeeks, overseasDays, totalWeeks, totalDays, semesterWeeks, semesterDays,
				 vacationWeeks, vacationDays, reason, annex);
	}
	
	@GetMapping("/pastrequest/leaverequestbyrid/{rid}")
	public LeaveRequest pastRequest(@PathVariable int rid) {
		return service.getRequest(rid);
	}
	
	@GetMapping("/pastrequest/getallleaverequest")
	public List<LeaveRequest> getAllrequest(){
		return service.getAllRequest();
	}
	
	@GetMapping("/pastrequest/leaverequest/{sid}")
	public List<LeaveRequest> pastLeaveRequest(@PathVariable int sid) {
		return service.pastLeaveRequest(sid);
	}
	
	@PutMapping("/updateleaverequest")
	public LeaveRequest updateRequest(@RequestBody LeaveRequest request) {
		return service.updateRequest(request);
	}
}

