package com.example.demo.controller;

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

import com.example.demo.entity.LateChanges;
import com.example.demo.entity.LateModuleChangeRequest;
import com.example.demo.entity.LeaveRequest;
import com.example.demo.service.LateModuleChangeRequestService;

@RestController
@CrossOrigin(origins = "*")
public class LateModuleChangeRequestController {

	@Autowired
	private LateModuleChangeRequestService service;
	
	@PostMapping("/request/latemodulechangerequest")
	public String submitLateModuleChangeRequest(@RequestParam int sid, @RequestParam MultipartFile annex, @RequestParam MultipartFile sgpa, 
			@RequestParam String reason, @RequestParam String isTrainingCompleted, @RequestParam String mcode[], @RequestParam String addOrDrop[], 
			@RequestParam int noOfAttendedLectures[], @RequestParam int noOfNotAttendedLectures[], @RequestParam int noOfMissedAssignments[]) {
		
		service.submitLateModuleChangeRequest(sid, annex, sgpa, reason, isTrainingCompleted, mcode, addOrDrop, 
				noOfAttendedLectures, noOfNotAttendedLectures, noOfMissedAssignments);
		
		return "Success";
	}
	
	@GetMapping("/pastrequest/latemodulechangerequestbyrid/{rid}")
	public LateModuleChangeRequest getLateModuleChangeRequest(@PathVariable int rid) {
			
		return service.getLateModuleChangeRequest(rid);
	}
	
	@GetMapping("/pastrequest/getallLateModuleChangerequest")
	public List<LateModuleChangeRequest> getAllLateModuleChangeRequest(){
		return service.getAllLateModuleChangeRequest();
	}
	
	@GetMapping("/pastrequest/latemodulechangerequest/{sid}")
	public List<LateModuleChangeRequest> pastLateModuleChangeRequest(@PathVariable int sid) {
		
		return service.pastLateModuleChangeRequest(sid);
	}
	
	@PutMapping("/updatelatemodulechangerequest")
	public LateModuleChangeRequest updaterequest(@RequestBody LateModuleChangeRequest request) {
		return service.updateRequest(request);
	}
}
