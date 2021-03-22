package com.example.demo.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@Entity
@Table
@PrimaryKeyJoinColumn
@SuperBuilder
public class OtherAppeal extends Request {

	private String appealbrief;
	private String appealSummary;
	private String scanCopyOfSGPAPath;
	private String isTrainingCompleted;
	
	public OtherAppeal(String annexPath, String decision, Date enteredDate, boolean isSendToFacBoard, Student std,
			String appealbrief, String appealSummary, String scanCopyOfSGPAPath, String isTrainingCompleted, String type) {
		super(annexPath, decision, enteredDate, isSendToFacBoard, std, type);
		this.appealbrief = appealbrief;
		this.appealSummary = appealSummary;
		this.scanCopyOfSGPAPath = scanCopyOfSGPAPath;
		this.isTrainingCompleted = isTrainingCompleted;
	}

	public OtherAppeal(String annexPath, String decision, Date enteredDate, boolean isSendToFacBoard, Student std, String type) {
		super(annexPath, decision, enteredDate, isSendToFacBoard, std, type);
	}
	
	public OtherAppeal() {
		super();
	}

	public String getAppealbrief() {
		return appealbrief;
	}

	public void setAppealbrief(String appealbrief) {
		this.appealbrief = appealbrief;
	}

	public String getAppealSummary() {
		return appealSummary;
	}

	public void setAppealSummary(String appealSummary) {
		this.appealSummary = appealSummary;
	}

	public String getScanCopyOfSGPAPath() {
		return scanCopyOfSGPAPath;
	}

	public void setScanCopyOfSGPAPath(String scanCopyOfSGPAPath) {
		this.scanCopyOfSGPAPath = scanCopyOfSGPAPath;
	}

	public String getIsTrainingCompleted() {
		return isTrainingCompleted;
	}

	public void setIsTrainingCompleted(String isTrainingCompleted) {
		this.isTrainingCompleted = isTrainingCompleted;
	}
	
	
}
