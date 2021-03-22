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

import com.example.demo.entity.OtherAppeal;
import com.example.demo.service.OtherAppealService;


@RestController
@CrossOrigin(origins = "*")
public class OtherAppealController {

	@Autowired
	private OtherAppealService service;
	
	@PostMapping("/request/otherappeal")
	public OtherAppeal submiOtherAppeal(@RequestParam int sid, @RequestParam String appealbrief, @RequestParam String appealSummary,
			@RequestParam String isTrainingCompleted, @RequestParam MultipartFile annex, @RequestParam MultipartFile sgpa) {
		
		return service.submiOtherAppeal(sid, appealbrief, appealSummary, isTrainingCompleted, annex, sgpa);
	}
	
	@GetMapping("/pastrequest/otherappealbyrid/{rid}")
	public OtherAppeal pastRequest(@PathVariable int rid) {
		return service.getRequest(rid);
	}
	
	@GetMapping("/pastrequest/getallAppeal")
	public List<OtherAppeal> getAllOtherAppeal(){
		return service.getAllOtherAppeal();
	}
	
	@GetMapping("/pastrequest/otherappeal/{sid}")
	public List<OtherAppeal> pastOtherAppeal(@PathVariable int sid) {
		
		return service.pastOtherAppeal(sid);
	}
	
	@PutMapping("/updateappeal")
	public OtherAppeal updateAppeal(@RequestBody OtherAppeal appeal) {
		return service.updateAppeal(appeal);
	}
}
