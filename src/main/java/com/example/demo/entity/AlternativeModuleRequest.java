package com.example.demo.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.experimental.SuperBuilder;

@Entity
@Table
@PrimaryKeyJoinColumn
@SuperBuilder
public class AlternativeModuleRequest extends Request {

	private String comment;
	
	@OneToMany(mappedBy = "alterModuleRequest")
    private List<ModuleDiscontinue> moduleDiscontinue;

	public AlternativeModuleRequest(String annexPath, String decision, Date enteredDate,
			boolean isSendToFacBoard, Student std, String comment, String type) {
		super(annexPath, decision, enteredDate, isSendToFacBoard, std, type);
		this.comment = comment;
	}

	public AlternativeModuleRequest(String annexPath, String decision, Date enteredDate,
			boolean isSendToFacBoard, Student std, String type) {
		super(annexPath, decision, enteredDate, isSendToFacBoard, std, type);
	}
	
	public AlternativeModuleRequest() {
		super();
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public List<ModuleDiscontinue> getModuleDiscontinue() {
		return moduleDiscontinue;
	}

	public void setModuleDiscontinue(List<ModuleDiscontinue> moduleDiscontinue) {
		this.moduleDiscontinue = moduleDiscontinue;
	}
	
}
