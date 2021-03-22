package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entity.Memo;
import com.example.demo.service.MemoService;

@RestController
@CrossOrigin(origins = "*")
public class MemoController {

	@Autowired
	private MemoService service;
	
	@PostMapping("/postmemo")
	public Memo postMemo(@RequestParam int facid, @RequestParam String description1, @RequestParam MultipartFile annex) {
		return service.postMemo(facid, description1, annex);
	}
	
	@GetMapping("/pastmemo/{mid}")
	public Memo getMemo(@PathVariable int mid) {
		return service.getMemo(mid);
	}
	
	@GetMapping("/pastallmemo")
	public List<Memo> getAllMemo(){
		return service.getAllMemo();
	}
	
	@GetMapping("/pastmemobyfacid/{facId}")
	public List<Memo> getMemoByFacId(@PathVariable int facId){
		return service.getMemoByFacId(facId);
	}
}
