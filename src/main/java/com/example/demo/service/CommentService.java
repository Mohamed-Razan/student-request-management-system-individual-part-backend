package com.example.demo.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Comment;
import com.example.demo.entity.CommentKey;
import com.example.demo.repository.CommentRepository;

@Service
public class CommentService {

	@Autowired
	private CommentRepository repository;
	
	@Autowired
	private RequestService requestService;
	
	@Autowired
	private FACMemberService facMemberService;
	
	public Comment postComment(int facId, int rid, String description1, boolean isRecommended, boolean isForwarded) {
		
		Date enteredDate = new Date();
		
		Comment comment = new Comment(facMemberService.getFACMember(facId), requestService.getRequest(rid), isForwarded, isRecommended, enteredDate, description1);
//		System.out.println(facId);
		return repository.save(comment);
	}
	
	public Comment getComment(int facId, int rid) {
		return repository.findById(new CommentKey(facId, rid)).orElse(null);
	}
}
