package com.example.demo.payload;
import java.util.List;

import lombok.Data;

@Data
public class UserDetailsResponse {
	private String token;
	private Long id;
	private String username;
	private String email;
	private List<String> roles;

	public UserDetailsResponse(String accessToken, Long id, String email, List<String> roles) {
		this.token = accessToken;
		this.id = id;
		this.username = email;
		this.email = email;
		this.roles = roles;
	}

}