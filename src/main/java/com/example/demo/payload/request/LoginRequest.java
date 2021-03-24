package com.example.demo.payload.request;

import javax.validation.constraints.NotBlank;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class LoginRequest {
	@NotBlank
	private String username;
	@NotBlank
	private String password;
}
