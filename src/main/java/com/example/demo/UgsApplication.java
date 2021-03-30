package com.example.demo;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.entity.MRoles;
import com.example.demo.entity.Roles;
import com.example.demo.entity.UgsStaff;
import com.example.demo.repository.RolesRepo;
import com.example.demo.repository.UgsStaffRepository;

@SpringBootApplication
public class UgsApplication implements CommandLineRunner{
	@Autowired
	private UgsStaffRepository repo;
	
	@Autowired
	private RolesRepo roleRepo;
	public static void main(String[] args) {
		SpringApplication.run(UgsApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
//		System.out.println(encoder.encode("12345"));
		Roles student = new Roles(MRoles.ROLE_STUDENT);
		Roles admin = new Roles(MRoles.ROLE_ADMIN);
		Roles ugsRole = new Roles(MRoles.ROLE_UGS);
//		Roles student = new Roles(MRoles.ROLE_STUDENT);
//		Roles student = new Roles(MRoles.ROLE_STUDENT);
//		Roles student = new Roles(MRoles.ROLE_STUDENT);
//		Roles student = new Roles(MRoles.ROLE_STUDENT);
		
		roleRepo.save(admin);
		roleRepo.save(ugsRole);
		roleRepo.save(student);
		
		
		UgsStaff ugs = new UgsStaff();
		ugs.setFirstName("Malith");
		ugs.setLastName("fernando");
		ugs.setEmail("fayaz@gmail.com");
		ugs.setContactNo("778366330");
		ugs.setPassword("$2a$10$NuUxIue/pmtKrU1t/MAo/em4cgD8UDsOh09xVgqmBAxOGzWtFc31O");
		
		
		Set<Roles> roles = new HashSet<Roles>();
		Roles roleAdmin = roleRepo.findByName(MRoles.ROLE_ADMIN).get();
		Roles roleUgs = roleRepo.findByName(MRoles.ROLE_UGS).get();
		
		roles.add(roleUgs);
		roles.add(roleAdmin);
		
		ugs.setRoles(roles);
		
		repo.save(ugs);
		
		System.out.println(repo.findById((long)1));
		
	}
//	@Bean
//	public WebMvcConfigurer configure() {
//		return new WebMvcConfigurer() {
//			@Override
//			public void addCorsMappings(CorsRegistry registry) {
//				registry.addMapping("/*").allowedOrigins("http://localhost:3000");
//			}
//		};
//	}

}
