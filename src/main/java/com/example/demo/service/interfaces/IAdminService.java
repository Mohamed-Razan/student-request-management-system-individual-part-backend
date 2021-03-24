package com.example.demo.service.interfaces;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.AssistantRegistrar;
import com.example.demo.entity.FacMember;
import com.example.demo.entity.UgsStaff;
import com.example.demo.entity.User;
import com.example.demo.payload.request.StudentBatchRequest;
import com.example.demo.payload.request.StudentSingleRegister;

public interface IAdminService {
	String saveStudent(StudentSingleRegister student);
//	TODO: List<Student> saveAll(file);
//	TODO: UGS STAFF || ADMIN 
	
	////	Student getStudentDetail(Long id);	
//	Student deleteStudentDetails(Student student);
////	Student updateStudentDetails(Student student); //this will be implemented from the serviceImpl  class
//	Student getStudentDetail(String indexNumber);
	
	Optional<User> findUserByUserName(String email);

	String saveFacMember(FacMember member);

	String saveAR(AssistantRegistrar ar);

	String saveUGS(UgsStaff ugs);

	int saveAll(List<StudentBatchRequest> students);
		
	
}
