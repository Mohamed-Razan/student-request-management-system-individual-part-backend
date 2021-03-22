package com.example.demo.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

@Entity
public class LateChanges {

	@EmbeddedId
    private LateChangesKey id;
 
    @ManyToOne
    @MapsId("RId")
    @JoinColumn(name = "rid")
    private LateModuleChangeRequest lateModuleChangeRequest;
 
    @ManyToOne
    @MapsId("mcode")
    @JoinColumn(name = "mcode")
    private Module1 module;
 
    private int NoOfAttendedLectures;
    private int NoOfNotAttendedLectures;
    private int NoOfMissedAssignments;
    private String remarks;
    private String addOrDrop;
    
	public LateChanges(LateModuleChangeRequest lateModuleChangeRequest, Module1 module,
			int noOfAttendedLectures, int noOfNotAttendedLectures, int noOfMissedAssignments, String remarks,
			String addOrDrop) {
		super();
		this.id = new LateChangesKey(lateModuleChangeRequest.getRid(), module.getMcode());
		this.lateModuleChangeRequest = lateModuleChangeRequest;
		this.module = module;
		NoOfAttendedLectures = noOfAttendedLectures;
		NoOfNotAttendedLectures = noOfNotAttendedLectures;
		NoOfMissedAssignments = noOfMissedAssignments;
		this.remarks = remarks;
		this.addOrDrop = addOrDrop;
	}

	public LateChanges() {
		super();
	}

	public LateChangesKey getId() {
		return id;
	}

	public void setId(LateChangesKey id) {
		this.id = id;
	}

	public Module1 getModule() {
		return module;
	}

	public void setModule(Module1 module) {
		this.module = module;
	}

	public int getNoOfAttendedLectures() {
		return NoOfAttendedLectures;
	}

	public void setNoOfAttendedLectures(int noOfAttendedLectures) {
		NoOfAttendedLectures = noOfAttendedLectures;
	}

	public int getNoOfNotAttendedLectures() {
		return NoOfNotAttendedLectures;
	}

	public void setNoOfNotAttendedLectures(int noOfNotAttendedLectures) {
		NoOfNotAttendedLectures = noOfNotAttendedLectures;
	}

	public int getNoOfMissedAssignments() {
		return NoOfMissedAssignments;
	}

	public void setNoOfMissedAssignments(int noOfMissedAssignments) {
		NoOfMissedAssignments = noOfMissedAssignments;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getAddOrDrop() {
		return addOrDrop;
	}

	public void setAddOrDrop(String addOrDrop) {
		this.addOrDrop = addOrDrop;
	}
	
	
    
	
}
