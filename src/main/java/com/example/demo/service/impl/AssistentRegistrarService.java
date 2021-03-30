package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.AssistantRegistrar;
import com.example.demo.repository.AssistentRegistrarRepository;

@Service
public class AssistentRegistrarService {

	@Autowired
	private AssistentRegistrarRepository repository;
	
	public AssistantRegistrar postAssistentRegistrar(AssistantRegistrar assistentRegistrar) {
		return repository.save(assistentRegistrar);
	}
}
