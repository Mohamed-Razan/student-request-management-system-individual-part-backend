package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.AssistantRegistrar;
import com.example.demo.service.impl.AssistentRegistrarService;

@RestController
@CrossOrigin(origins = "*")
public class AssistentRegistrarController {

	@Autowired
	private AssistentRegistrarService service;
	
	@PostMapping("/regassistentregistrar")
	public AssistantRegistrar postAssistentRegistrar(@RequestBody AssistantRegistrar assistentRegistrar) {
		return service.postAssistentRegistrar(assistentRegistrar);
	}
}
