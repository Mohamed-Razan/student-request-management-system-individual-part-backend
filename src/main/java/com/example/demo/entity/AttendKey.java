package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class AttendKey implements Serializable {

	@Column(name = "fac_member_id")
	private int facMemberId;
	
	@Column(name = "fac_meeting_id")
	private int facMeetingId;

	public AttendKey(int facMemberId, int facMeetingId) {
		super();
		this.facMemberId = facMemberId;
		this.facMeetingId = facMeetingId;
	}

	public AttendKey() {
		super();
	}

	public int getFacMemberId() {
		return facMemberId;
	}

	public void setFacMemberId(int facMemberId) {
		this.facMemberId = facMemberId;
	}

	public int getFacMeetingId() {
		return facMeetingId;
	}

	public void setFacMeetingId(int facMeetingId) {
		this.facMeetingId = facMeetingId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + facMeetingId;
		result = prime * result + facMemberId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AttendKey other = (AttendKey) obj;
		if (facMeetingId != other.facMeetingId)
			return false;
		if (facMemberId != other.facMemberId)
			return false;
		return true;
	}
	
	
	
	
}
