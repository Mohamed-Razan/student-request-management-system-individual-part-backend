package com.example.demo.payload.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class StudentSingleRegister {
	@NotBlank
	private String indexNumber;
	@NotBlank
	private String firstName;
	@NotBlank
	private String lastName;
	@NotBlank
	@Email
	private String email;

	@NotBlank
	@Size(min=8, max = 20)
	private String password;

	@NotBlank
	private String contactNumber;
	@NotBlank
	private String batch;
	@NotBlank
	private String course;
	@NotBlank
	private String levelSem;
	

//	TODO:Academic advisor assign

}