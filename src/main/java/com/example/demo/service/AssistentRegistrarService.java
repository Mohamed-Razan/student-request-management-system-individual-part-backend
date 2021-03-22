package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.AssistentRegistrar;
import com.example.demo.repository.AssistentRegistrarRepository;

@Service
public class AssistentRegistrarService {

	@Autowired
	private AssistentRegistrarRepository repository;
	
	public AssistentRegistrar postAssistentRegistrar(AssistentRegistrar assistentRegistrar) {
		return repository.save(assistentRegistrar);
	}
}
