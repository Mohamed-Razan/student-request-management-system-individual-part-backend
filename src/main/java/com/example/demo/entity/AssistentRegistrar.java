package com.example.demo.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@Entity
@Table
@PrimaryKeyJoinColumn
@SuperBuilder
public class AssistentRegistrar extends User {

	public AssistentRegistrar() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AssistentRegistrar(String userName, String userEmail, String userPasswordHashed, String contactNo) {
		super(userName, userEmail, userPasswordHashed, contactNo);
		// TODO Auto-generated constructor stub
	}

	@OneToMany(mappedBy = "assistantRegistrar")
	private List<FACMeeting> facMeetings;
}
