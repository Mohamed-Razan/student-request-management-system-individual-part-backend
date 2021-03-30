package com.example.demo.utils;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtUtil {
	
	@Value("${app.secretkey}")
	private String secret_key;
	
//	GENERATE TOKEN 
	public String generateToken(String username) {
		return Jwts.builder()
			.setSubject(username)
			.setIssuer("UGS@IT")
			.setIssuedAt(new Date(System.currentTimeMillis()))
			.setExpiration(new Date(System.currentTimeMillis()+ TimeUnit.MINUTES.toMillis(10)))
			.signWith(SignatureAlgorithm.HS256, secret_key.getBytes())
			.compact();
	}
	
//	Read claims from the TOKEN 
	public Claims readClaims(String token) {
		return Jwts.parser()
				.setSigningKey(secret_key.getBytes())
				.parseClaimsJws(token)
				.getBody();
	}
	
	//Expiration date for validating token
	public Date readExpiryDate(String token) {
		Date expiration = readClaims(token).getExpiration();
		return expiration;
	}
	
	//validate token if user name in db and token are equal and the token should not be expired
	public boolean isTokenValid(String token,String dbUserName) {
		String username = readUserName(token);
		return username.equals(dbUserName) && !isTokenExpired(token);
	}
	
	//Get UserName
	public String readUserName(String token) {
		String subject = readClaims(token).getSubject();
		return subject;
	}
	//check whether the token is expired  return true if the getExpiration() is before the currentDate time
	public boolean isTokenExpired(String token) {
		Date today = new Date(System.currentTimeMillis());
		return readExpiryDate(token).before(today);
	}
}
