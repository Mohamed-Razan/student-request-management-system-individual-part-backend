package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;
@Data
@Embeddable
public class CommentKey implements Serializable {

	/**
	 * Added Default serializable value by shaja Nasir
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "FAC_Id")
	private Long FACId;
	
	@Column(name = "rid")
	private int rid;

	public CommentKey(long facId2, int rid) {
		super();
		FACId = facId2;
		this.rid = rid;
	}

	public CommentKey() {
		super();
	}

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (int) (prime * result + FACId);
		result = prime * result + rid;
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
		CommentKey other = (CommentKey) obj;
		if (FACId != other.FACId)
			return false;
		if (rid != other.rid)
			return false;
		return true;
	}
	
	
	
	
}
