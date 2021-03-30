package com.example.demo.controller;

import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entity.AssistantRegistrar;
import com.example.demo.entity.FacMember;
import com.example.demo.entity.UgsStaff;
import com.example.demo.payload.request.StudentBatchRequest;
import com.example.demo.payload.request.StudentSingleRegister;
import com.example.demo.service.interfaces.IAdminService;
import com.example.demo.utils.ExcelHelper;


@RestController
@RequestMapping("/admin")
public class AdminController {

	private static Logger log = Logger.getLogger(AdminController.class);

	@Autowired
	private ExcelHelper helper;

	@Autowired
	private IAdminService service;

	@PostMapping("/register/student/single")
	public ResponseEntity<String> registerSingleStudent(@Valid @RequestBody StudentSingleRegister registerStudent) {
		log.info("Registration of Single Student called, Index:" + registerStudent.getIndexNumber());
		String index = service.saveStudent(registerStudent);
		return ResponseEntity.ok("Registration Successfull Index Number: " + index);
	}

//	TODO: register multiple student user
	@PostMapping("/register/student/batch/upload")
	public ResponseEntity<List<StudentBatchRequest>> registerBatchStudent(@RequestPart("file") MultipartFile file) {
		log.info("Registration of batch students called");
		List<StudentBatchRequest> users;
		if (helper.isExcel(file)) {
			try {
				users = helper.getAllUsers(file.getInputStream());
			} catch (IOException e) {
				throw new RuntimeException("fail to store excel data: " + e.getMessage());
			}
		} else {
			users = null;
		}
		return ResponseEntity.ok(users);

	}
	
	@PostMapping("/register/student/batch/saveAll")
	public ResponseEntity<String> saveAllUsers(@RequestBody List<StudentBatchRequest> students){
		int size = service.saveAll(students);
		return ResponseEntity.ok("No of Students registered: " + size);
	}

//	TODO: register FAC members user
	@PostMapping("/register/fac")
	public ResponseEntity<String> registerFAC(@RequestBody FacMember member) {
		log.info("Registration of FACMember called, Email:" + member.getEmail());
		String email = service.saveFacMember(member);
		return ResponseEntity.ok("Registration Completed with  Email: " + email);
	}

//	TODO: register Assistant registrater user
	@PostMapping("/register/ar")
	public ResponseEntity<String> registerAssistantReg(@RequestBody AssistantRegistrar ar) {
		log.info("Registration of Assistant Registrar called, Email:" + ar.getEmail());
		String email = service.saveAR(ar);
		return ResponseEntity.ok("Registration Completed with  Email: " + email);
	}

//	TODO: register ugs staff user
	@PostMapping("/register/ugs")
	public ResponseEntity<String> registerAssistantReg(@RequestBody UgsStaff ugs) {
		log.info("Registration of FACMember called, Email:" + ugs.getEmail());
		String email = service.saveUGS(ugs);
		return ResponseEntity.ok("Registration Completed with  Email: " + email);
	}
	
}
