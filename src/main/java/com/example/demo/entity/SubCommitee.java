package com.example.demo.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class SubCommitee {

	@Id
	@GeneratedValue
	private int subCommiteeId;
	private String purpose;
	private String discripition1;
	private Date appointedDate;
	private String reportURL;
	private Date reportSubmissionDate;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private FACMeeting createdFacMeeting;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private FACMeeting reportSubmittedFacMeeting;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private FACMember leader;
	
	@ManyToMany()
	@JoinTable(
			name = "subcommitee_participants",
			joinColumns = @JoinColumn(),
			inverseJoinColumns = @JoinColumn()
			)
	private List<FACMember> facmember;
	
	public SubCommitee(String purpose, String discripition1, Date appointedDate, FACMember leader, List<FACMember> facmember) {
		super();
		this.purpose = purpose;
		this.discripition1 = discripition1;
		this.appointedDate = appointedDate;
		this.facmember = facmember;
		this.leader = leader;
	}

	public SubCommitee() {
		super();
	}

	public int getSubCommiteeId() {
		return subCommiteeId;
	}

	public void setSubCommiteeId(int subCommiteeId) {
		this.subCommiteeId = subCommiteeId;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	public String getDiscripition1() {
		return discripition1;
	}

	public void setDiscripition1(String discripition1) {
		this.discripition1 = discripition1;
	}

	public Date getAppointedDate() {
		return appointedDate;
	}

	public void setAppointedDate(Date appointedDate) {
		this.appointedDate = appointedDate;
	}

	public String getReportURL() {
		return reportURL;
	}

	public void setReportURL(String reportURL) {
		this.reportURL = reportURL;
	}

	public Date getReportSubmissionDate() {
		return reportSubmissionDate;
	}

	public void setReportSubmissionDate(Date reportSubmissionDate) {
		this.reportSubmissionDate = reportSubmissionDate;
	}

	public FACMeeting getCreatedFacMeeting() {
		return createdFacMeeting;
	}

	public void setCreatedFacMeeting(FACMeeting createdFacMeeting) {
		this.createdFacMeeting = createdFacMeeting;
	}

	public FACMeeting getReportSubmittedFacMeeting() {
		return reportSubmittedFacMeeting;
	}

	public void setReportSubmittedFacMeeting(FACMeeting reportSubmittedFacMeeting) {
		this.reportSubmittedFacMeeting = reportSubmittedFacMeeting;
	}

	public FACMember getLeader() {
		return leader;
	}

	public void setLeader(FACMember leader) {
		this.leader = leader;
	}

	public List<FACMember> getFacmember() {
		return facmember;
	}

	public void setFacmember(List<FACMember> facmember) {
		this.facmember = facmember;
	}
	
}
