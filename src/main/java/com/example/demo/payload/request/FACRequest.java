package com.example.demo.payload.request;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class FACRequest {
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
	
	
}
