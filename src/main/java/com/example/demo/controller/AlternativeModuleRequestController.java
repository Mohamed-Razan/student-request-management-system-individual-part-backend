package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entity.AlternativeModuleRequest;
import com.example.demo.entity.LeaveRequest;
import com.example.demo.entity.ModuleDiscontinue;
import com.example.demo.entity.ModuleDiscontinueKey;
import com.example.demo.entity.OtherAppeal;
import com.example.demo.service.AlternativeModuleRequestService;



@RestController
@CrossOrigin(origins = "*")
public class AlternativeModuleRequestController {

	@Autowired
	private AlternativeModuleRequestService alterService;
	
	
	@PostMapping("/request/alternativemodulerequest")
	public String submitAlternativeModuleRequest(@RequestParam int sid, @RequestParam MultipartFile annex, @RequestParam String discontinueMcode[],
			@RequestParam String currentGrade[], @RequestParam String comment) {
		
		alterService.submitAlternativemoduleRequest(sid, annex, discontinueMcode, currentGrade, comment);
		
		return "Success";
	}
	
	@GetMapping("/pastrequest/getallalternativemodulerequest")
	public List<AlternativeModuleRequest> getAllRequest(){
		return alterService.getAllRequest();
	}
	
	@GetMapping("/pastrequest/alternativemodulerequestbyrid/{rid}")
	public AlternativeModuleRequest getModuleDiscontinue(@PathVariable int rid) {
			
		return alterService.getModuleDiscontinue(rid);
	}
	
	@GetMapping("/pastrequest/alternativemodulerequest/{sid}")
	public List<AlternativeModuleRequest> pastLeaveRequest(@PathVariable int sid) {
		
		return alterService.pastAlternativeModuleRequest(sid);
	}
	
	@PutMapping("/updateAlterRequest")
	public String updateRequest(@RequestParam int rid, @RequestParam String decision, @RequestParam String alterMcode[], @RequestParam String offeringSem[]) {
		
		return alterService.updateRequest(rid, decision, alterMcode, offeringSem);
	}
}
