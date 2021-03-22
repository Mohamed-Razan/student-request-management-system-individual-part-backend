package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Module1;
import com.example.demo.service.ModuleService;


@RestController
@CrossOrigin(origins = "*")
public class ModuleController {
	@Autowired
	private ModuleService service;
	
	@PostMapping("/addmodule")
	public Module1 addModule(@RequestBody Module1 module) {
		return service.postModule(module);
	}
}
