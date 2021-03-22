package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Comment;
import com.example.demo.service.CommentService;

@RestController
@CrossOrigin(origins = "*")
public class CommentController {

	@Autowired
	private CommentService service;
	
	@PostMapping("/postcomment")
	public Comment postComment(@RequestParam int facId, @RequestParam int rid,  @RequestParam String description1, @RequestParam boolean isRecommended, 
			@RequestParam boolean isForwarded) {
		
		return service.postComment(facId, rid, description1, isRecommended, isForwarded);
	}
	
	@GetMapping("/getcomment/{facId}/{rid}")
	public Comment getComment(@PathVariable int facId, @PathVariable int rid) {
		return service.getComment(facId, rid);
	}
}
