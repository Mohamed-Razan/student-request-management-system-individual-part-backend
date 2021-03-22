package com.example.demo.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
public class FACMember extends User {

	private String department;
	private boolean isAcademicAdvisor;
	private boolean isHod;
	private boolean isDean;
	private boolean isDugs;
	private boolean isOnlyLecturer;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "facMember")
	private List<Memo> memos;
	
	@OneToMany(mappedBy = "facMember")
	private List<Comment> comments;
	
	@OneToMany(mappedBy = "facMember")
	private List<Attend> attends;
	
	@OneToMany(mappedBy = "leader")
	private List<SubCommitee> leaderOfSubCommitee;
	
	@ManyToMany(mappedBy = "facmember")
	private List<SubCommitee> subCommitee;

	public FACMember(String userName, String userEmail, String userPasswordHashed, String contactNo, String department,
			boolean isAcademicAdvisor, boolean isHod, boolean isDean, boolean isDugs, boolean isOnlyLecturer,
			List<Memo> memos) {
		super(userName, userEmail, userPasswordHashed, contactNo);
		this.department = department;
		this.isAcademicAdvisor = isAcademicAdvisor;
		this.isHod = isHod;
		this.isDean = isDean;
		this.isDugs = isDugs;
		this.isOnlyLecturer = isOnlyLecturer;
		this.memos = memos;
	}

	public FACMember(String userName, String userEmail, String userPasswordHashed, String contactNo) {
		super(userName, userEmail, userPasswordHashed, contactNo);
	}
	
	public FACMember() {
		super();
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public boolean getIsAcademicAdvisor() {
		return isAcademicAdvisor;
	}

	public void setIsAcademicAdvisor(boolean isAcademicAdvisor) {
		this.isAcademicAdvisor = isAcademicAdvisor;
	}

	public boolean getIsHod() {
		return isHod;
	}

	public void setIsHod(boolean isHod) {
		this.isHod = isHod;
	}

	public boolean getIsDean() {
		return isDean;
	}

	public void setIsDean(boolean isDean) {
		this.isDean = isDean;
	}

	public boolean getIsDugs() {
		return isDugs;
	}

	public void setIsDugs(boolean isDugs) {
		this.isDugs = isDugs;
	}

	public boolean getIsOnlyLecturer() {
		return isOnlyLecturer;
	}

	public void setIsOnlyLecturer(boolean isOnlyLecturer) {
		this.isOnlyLecturer = isOnlyLecturer;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public List<Attend> getAttends() {
		return attends;
	}

	public void setAttends(List<Attend> attends) {
		this.attends = attends;
	}
	
	
}
