package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.AssistentRegistrar;
import com.example.demo.service.AssistentRegistrarService;

@RestController
@CrossOrigin(origins = "*")
public class AssistentRegistrarController {

	@Autowired
	private AssistentRegistrarService service;
	
	@PostMapping("/regassistentregistrar")
	public AssistentRegistrar postAssistentRegistrar(@RequestBody AssistentRegistrar assistentRegistrar) {
		return service.postAssistentRegistrar(assistentRegistrar);
	}
}
