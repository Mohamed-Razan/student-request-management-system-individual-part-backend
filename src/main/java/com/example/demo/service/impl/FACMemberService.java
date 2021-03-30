package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.FacMember;
import com.example.demo.repository.FACMemberRepository;

@Service
public class FACMemberService {

	@Autowired
	private FACMemberRepository repo;
	
	public FacMember postFACMember(FacMember facMember) {
		return repo.save(facMember);
	}
	
	public FacMember getFACMember(int FACId) {
		return repo.findById(FACId).orElse(null);
	}
}
