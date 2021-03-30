package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Request;
import com.example.demo.service.impl.RequestService;

@RestController
public class RequestController {

	@Autowired
	private RequestService service;
	
	@GetMapping("/getrequestbyrid/{rid}")
	public Request getRequest(@PathVariable int rid) {
		return service.getRequest(rid);
	}
	
	@GetMapping("/getrequestbysid/{sid}")
	public List<Request> getRequestBySid(@PathVariable int sid){
		return service.getRequestBySid(sid);
	}
}
