package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;
@Data
@Embeddable
public class AttendKey implements Serializable {

	/**
	 * Added Default serializable value by shaja Nasir
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "fac_member_id")
	private Long facMemberId;
	
	@Column(name = "fac_meeting_id")
	private int facMeetingId;

	public AttendKey(long facMemberId, int facMeetingId) {
		super();
		this.facMemberId = facMemberId;
		this.facMeetingId = facMeetingId;
	}

	public AttendKey() {
		super();
	}

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + facMeetingId;
		result = (int) (prime * result + facMemberId);
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
