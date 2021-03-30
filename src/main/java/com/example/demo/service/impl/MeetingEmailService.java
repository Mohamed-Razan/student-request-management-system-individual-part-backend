package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MeetingEmailService {
	
	@Autowired
	private JavaMailSender javaMailSender;

	public void sendEmail(String to, String body, String topic) {
		
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		
		simpleMailMessage.setFrom("mhdrazan7@gmail.com");
		simpleMailMessage.setTo(to);
		simpleMailMessage.setSubject(topic);
		simpleMailMessage.setText(body);
		
		javaMailSender.send(simpleMailMessage);
	}
}
