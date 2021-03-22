package com.example.demo.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@Entity
@Table
@PrimaryKeyJoinColumn
@SuperBuilder
public class LeaveRequest extends Request {
	
	private String leaveType;
	private String purpose;
	private Date dateFrom = new Date();
	private Date dateTo = new Date();
	private int localWeeks;
	private int localDays;
	private int overseasWeeks;
	private int overseasDays;
	private int totalWeeks;
	private int totalDays;
	private int semesterWeeks;
	private int semesterDays;
	private int vacationWeeks;
	private int vacationDays;
	private String reason;

	public LeaveRequest(String annexPath, String decision, Date enteredDate, boolean isSendToFacBoard,
			String leaveType, String purpose, Date dateFrom, Date dateTo, int localWeeks, int localDays,
			int overseasWeeks, int overseasDays, int totalWeeks, int totalDays, int semesterWeeks, int semesterDays,
			int vacationWeeks, int vacationDays, String reason, Student std, String type) {
		super(annexPath, decision, enteredDate, isSendToFacBoard, std, type);
		this.leaveType = leaveType;
		this.purpose = purpose;
		this.dateFrom = dateFrom;
		this.dateTo = dateTo;
		this.localWeeks = localWeeks;
		this.localDays = localDays;
		this.overseasWeeks = overseasWeeks;
		this.overseasDays = overseasDays;
		this.totalWeeks = totalWeeks;
		this.totalDays = totalDays;
		this.semesterWeeks = semesterWeeks;
		this.semesterDays = semesterDays;
		this.vacationWeeks = vacationWeeks;
		this.vacationDays = vacationDays;
		this.reason = reason;
	}
	
	
	public LeaveRequest(String annexPath, String decision, Date enteredDate, boolean isSendToFacBoard,
			Student std, String type) {
		super(annexPath, decision, enteredDate, isSendToFacBoard, std, type);
	}
	
	public LeaveRequest() {
		super();
	}


	public String getLeaveType() {
		return leaveType;
	}
	public void setLeaveType(String leaveType) {
		this.leaveType = leaveType;
	}
	public String getPurpose() {
		return purpose;
	}
	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}
	public Date getDateFrom() {
		return dateFrom;
	}
	public void setDateFrom(Date dateFrom) {
		this.dateFrom = dateFrom;
	}
	public Date getDateTo() {
		return dateTo;
	}
	public void setDateTo(Date dateTo) {
		this.dateTo = dateTo;
	}
	public int getLocalWeeks() {
		return localWeeks;
	}
	public void setLocalWeeks(int localWeeks) {
		this.localWeeks = localWeeks;
	}
	public int getLocalDays() {
		return localDays;
	}
	public void setLocalDays(int localDays) {
		this.localDays = localDays;
	}
	public int getOverseasWeeks() {
		return overseasWeeks;
	}
	public void setOverseasWeeks(int overseasWeeks) {
		this.overseasWeeks = overseasWeeks;
	}
	public int getOverseasDays() {
		return overseasDays;
	}
	public void setOverseasDays(int overseasDays) {
		this.overseasDays = overseasDays;
	}
	public int getTotalWeeks() {
		return totalWeeks;
	}
	public void setTotalWeeks(int totalWeeks) {
		this.totalWeeks = totalWeeks;
	}
	public int getTotalDays() {
		return totalDays;
	}
	public void setTotalDays(int totalDays) {
		this.totalDays = totalDays;
	}
	public int getSemesterWeeks() {
		return semesterWeeks;
	}
	public void setSemesterWeeks(int semesterWeeks) {
		this.semesterWeeks = semesterWeeks;
	}
	public int getSemesterDays() {
		return semesterDays;
	}
	public void setSemesterDays(int semesterDays) {
		this.semesterDays = semesterDays;
	}
	public int getVacationWeeks() {
		return vacationWeeks;
	}
	public void setVacationWeeks(int vacationWeeks) {
		this.vacationWeeks = vacationWeeks;
	}
	public int getVacationDays() {
		return vacationDays;
	}
	public void setVacationDays(int vacationDays) {
		this.vacationDays = vacationDays;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	
	
	
}

