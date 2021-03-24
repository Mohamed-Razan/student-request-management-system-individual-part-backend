package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.FacMember;
import com.example.demo.entity.SubCommitee;
import com.example.demo.repository.SubCommiteeRepository;

@Service
public class SubCommiteeService {

	@Autowired
	private SubCommiteeRepository repository;
	
	@Autowired
	private FACMemberService facMemberService;
	
	public SubCommitee postSubCommitee(String purpose, String discripition1, int leaderId, int facMemberId[]) {
		Date appointedDate = new Date();
		
		List<FacMember> facMember = new ArrayList<>();
		
		for(int i = 0; i < facMemberId.length; i++) {
			facMember.add(facMemberService.getFACMember(facMemberId[i]));
		}
		SubCommitee subCommitee = new SubCommitee(purpose, discripition1, appointedDate, facMemberService.getFACMember(leaderId), facMember);
		
		return repository.save(subCommitee);
	}
}
