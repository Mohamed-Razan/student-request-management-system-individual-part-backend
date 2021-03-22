package com.example.demo.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

@Entity
public class Attend {

	@EmbeddedId
	private AttendKey Id;
	
	@ManyToOne
    @MapsId("facMemberId")
    @JoinColumn(name = "fac_member_id")
    private FACMember facMember;

    @ManyToOne
    @MapsId("facMeetingId")
    @JoinColumn(name = "fac_meeting_id")
    private FACMeeting facMeeting;
    
    private boolean attendence;
    private String apology;
    
	public Attend(FACMember facMember, FACMeeting facMeeting, boolean attendence, String apology) {
		super();
		Id = new AttendKey(facMember.getUserId(), facMeeting.getMid());
		this.facMember = facMember;
		this.facMeeting = facMeeting;
		this.attendence = attendence;
		this.apology = apology;
	}

	public Attend() {
		super();
	}



	public AttendKey getId() {
		return Id;
	}

	public void setId(AttendKey id) {
		Id = id;
	}

	public boolean isAttendence() {
		return attendence;
	}

	public void setAttendence(boolean attendence) {
		this.attendence = attendence;
	}

	public String getApology() {
		return apology;
	}

	public void setApology(String apology) {
		this.apology = apology;
	}
	
	
    
    
}
