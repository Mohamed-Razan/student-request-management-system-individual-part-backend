package com.example.demo.entity;


import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sun.istack.NotNull;

@Entity
@Table
public class FACMeeting {

	@Id
	@GeneratedValue
	private int mid;
	@Temporal(TemporalType.TIMESTAMP)
	private Date meetingDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date meetingTime;
	
	private String location;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "facMeeting")
	private List<Memo> memos;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "facMeeting1")
	private List<Request> requests;
	
	@OneToMany(mappedBy = "facMeeting")
	private List<Attend> attends;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private AssistentRegistrar assistantRegistrar;
	
	private boolean assRegAttend;
	private String assRegApology;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "createdFacMeeting")
	private List<SubCommitee> createSubCommitee;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "reportSubmittedFacMeeting")
	private List<SubCommitee> reportSubmittedSubCommitee;

	public FACMeeting(Date meetingDate, Date meetingTime, String location) {
		super();
		this.meetingDate = meetingDate;
		this.location = location;
		this.meetingTime = meetingTime;
	}

	public FACMeeting() {
		super();
	}

	public int getMid() {
		return mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}

	public Date getMeetingDate() {
		return meetingDate;
	}

	public void setMeetingDate(Date meetingDate) {
		this.meetingDate = meetingDate;
	}

	public Date getMeetingTime() {
		return meetingTime;
	}

	public void setMeetingTime(Date meetingTime) {
		this.meetingTime = meetingTime;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public List<Attend> getAttends() {
		return attends;
	}

	public void setAttends(List<Attend> attends) {
		this.attends = attends;
	}

	public AssistentRegistrar getAssistantRegistrar() {
		return assistantRegistrar;
	}

	public void setAssistantRegistrar(AssistentRegistrar assistantRegistrar) {
		this.assistantRegistrar = assistantRegistrar;
	}

	public boolean isAssRegAttend() {
		return assRegAttend;
	}

	public void setAssRegAttend(boolean assRegAttend) {
		this.assRegAttend = assRegAttend;
	}

	public String getAssRegApology() {
		return assRegApology;
	}

	public void setAssRegApology(String assRegApology) {
		this.assRegApology = assRegApology;
	}
	
	
}
