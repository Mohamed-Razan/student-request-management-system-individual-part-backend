package com.example.demo.service.impl;


import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.entity.AssistantRegistrar;
import com.example.demo.entity.FacMember;
import com.example.demo.entity.MRoles;
import com.example.demo.entity.Roles;
import com.example.demo.entity.Student;
import com.example.demo.entity.UgsStaff;
import com.example.demo.entity.User;
import com.example.demo.payload.request.StudentBatchRequest;
import com.example.demo.payload.request.StudentSingleRegister;
import com.example.demo.repository.AssistentRegistrarRepository;
import com.example.demo.repository.FACMemberRepository;
import com.example.demo.repository.RolesRepo;
import com.example.demo.repository.StudentRepository;
import com.example.demo.repository.UgsStaffRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.interfaces.IAdminService;
import com.example.demo.utils.EmailUtil;


@Service
public class AdminServiceImpl implements IAdminService, UserDetailsService {
	@Autowired
	private BCryptPasswordEncoder encoder;

	@Autowired
	private StudentRepository studentRepo;

	@Autowired
	private FACMemberRepository facRepo;

	@Autowired
	private AssistentRegistrarRepository arRepo;

	@Autowired
	private UgsStaffRepository ugsRepo;

	@Autowired
	private UserRepository user;
	
	@Autowired
	private RolesRepo roleRepo;
	
	@Autowired
	private EmailUtil email;


	@Override
	public String saveStudent(StudentSingleRegister studentReq) {
		if (user.existsByEmail(studentReq.getEmail())) {
			return null;
		}

		if (studentRepo.existsByIndexNo(studentReq.getIndexNumber())) {
			return null;
		}
		Student student = new Student();
		student.setFirstName(studentReq.getFirstName());
		student.setLastName(studentReq.getLastName());
		student.setEmail(studentReq.getEmail());
		student.setPassword(encoder.encode(studentReq.getPassword()));
		student.setContactNo(studentReq.getContactNumber());
		student.setBatchYear(studentReq.getBatch());
		student.setCourseTitle(studentReq.getCourse());
		student.setLevelSemester(studentReq.getLevelSem());
		student.setIndexNo(studentReq.getIndexNumber());
	
		Set<Roles> roles = new HashSet<Roles>();
		Roles stdRole = roleRepo.findByName(MRoles.ROLE_STUDENT).get();
		roles.add(stdRole);
		student.setRoles(roles);
		return studentRepo.save(student).getIndexNo();
	}
	
	@Override
	public int saveAll(List<StudentBatchRequest> students) {
		for(int i = 0;i < students.size();i++) {
			StudentBatchRequest oneStudent = students.get(i);
			Student student = new Student();
			student.setFirstName(oneStudent.getFirstName());
			student.setLastName(oneStudent.getLastName());
			student.setEmail(oneStudent.getEmail());
			String password = encoder.encode(oneStudent.getIndexNo()).substring(0,10);
			
			student.setPassword(encoder.encode(password));
			student.setContactNo(oneStudent.getContactNo());
			student.setBatchYear(oneStudent.getBatchYear());
			student.setCourseTitle(oneStudent.getCourseTitle());
			student.setLevelSemester(oneStudent.getLevelSemester());
			student.setIndexNo(oneStudent.getIndexNo());
			Set<Roles> roles = new HashSet<Roles>();
			Roles stdRole = roleRepo.findByName(MRoles.ROLE_STUDENT).get();
			roles.add(stdRole);
			student.setRoles(roles);
			studentRepo.save(student);
			String message = "Hello from Division of Undergraduate Studies \n"
					+ "Please use the following password to log in to the system "
					+"\n "+password+"\n"+
					"Please be kind to change the password soon after your first login";
			email.sendEmail(student.getEmail(), "One Time Login Password", message);
		}
		return students.size();
	}

	@Override
	public String saveFacMember(FacMember member) {
		String email = facRepo.save(member).getEmail();
		return email;
	}

	@Override
	public String saveAR(AssistantRegistrar ar) {
		String email = arRepo.save(ar).getEmail();
		return email;
	}

	@Override
	public String saveUGS(UgsStaff ugs) {
		String email = ugsRepo.save(ugs).getEmail();
		return email;
	}

	@Override
	public Optional<User> findUserByUserName(String email) {
		return user.findByEmail(email);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> optional = findUserByUserName(username);
		if (optional.isEmpty()) {
			throw new UsernameNotFoundException("User with email: " + username + " not found");
		}

		User user = optional.get();
		return UserDetailsImpl.build(user);
	}

	

}
