package com.example.demo.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Data
@Entity
@Table
public class Memo {

	@Id
	@GeneratedValue
	private int mid;
	private String description1;
	private String annexPath;
	private Date enteredDate = new Date();
	private String decision;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn
	private FACMember facMember;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private FACMeeting facMeeting; 
	

	public Memo(String description1, String annexPath, Date enteredDate, FACMember facMember, String decision) {
		super();
		this.description1 = description1;
		this.annexPath = annexPath;
		this.enteredDate = enteredDate;
		this.facMember = facMember;
		this.decision  = decision;
	}

	public Memo() {
		super();
	}

	public int getMid() {
		return mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}

	public String getDescription1() {
		return description1;
	}

	public void setDescription1(String description1) {
		this.description1 = description1;
	}

	public String getAnnexPath() {
		return annexPath;
	}

	public void setAnnexPath(String annexPath) {
		this.annexPath = annexPath;
	}

	public Date getEnteredDate() {
		return enteredDate;
	}

	public void setEnteredDate(Date enteredDate) {
		this.enteredDate = enteredDate;
	}

	public FACMember getFacMember() {
		return facMember;
	}

	public void setFacMember(FACMember facMember) {
		this.facMember = facMember;
	}

	public FACMeeting getFacMeeting() {
		return facMeeting;
	}

	public void setFacMeeting(FACMeeting facMeeting) {
		this.facMeeting = facMeeting;
	}

	public String getDecision() {
		return decision;
	}

	public void setDecision(String decision) {
		this.decision = decision;
	}
	
	
	
	
}
