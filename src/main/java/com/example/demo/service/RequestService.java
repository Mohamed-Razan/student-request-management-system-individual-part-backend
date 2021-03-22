package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Request;
import com.example.demo.repository.RequestRepository;

@Service
public class RequestService {

	@Autowired
	private RequestRepository repository;

	@Autowired
	private StudentService service;

	public Request getRequest(int rid) {
		return repository.findById(rid).orElse(null);
	}

	public List<Request> getRequestBySid(int sid) {
		return repository.findByStd(service.getStudent(sid));
	}
}
