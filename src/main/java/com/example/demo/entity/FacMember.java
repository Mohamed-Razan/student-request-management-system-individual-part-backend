package com.example.demo.entity;

import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.EqualsAndHashCode;


@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class FacMember extends User{
	private String department;
	
	@JsonProperty("isAcademicAdvisor")
	private boolean isAcademicAdvisor;
	
	@JsonProperty("isHod")
	private boolean isHod;
	
	@JsonProperty("isDean")
	private boolean isDean;
	
	@JsonProperty("isDugs")
	private boolean isDugs;
	
	@JsonProperty("isOnlyLecturer")
	private boolean isOnlyLecturer;

	public FacMember() {
		this.isAcademicAdvisor = false;
		this.isDean = false;
		this.isHod = false;
		this.isOnlyLecturer = true;
		
	}
	
	
	
	
	
	
}
