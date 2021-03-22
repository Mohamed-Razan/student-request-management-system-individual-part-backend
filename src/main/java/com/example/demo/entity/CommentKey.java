package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class CommentKey implements Serializable {

	@Column(name = "FAC_Id")
	private int FACId;
	
	@Column(name = "rid")
	private int rid;

	public CommentKey(int fACId, int rid) {
		super();
		FACId = fACId;
		this.rid = rid;
	}

	public CommentKey() {
		super();
	}

	public int getFACId() {
		return FACId;
	}

	public void setFACId(int fACId) {
		FACId = fACId;
	}

	public int getRid() {
		return rid;
	}

	public void setRid(int rid) {
		this.rid = rid;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + FACId;
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
