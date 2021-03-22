package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class LateChangesKey implements Serializable {

	@Column(name = "rid")
    private int RId;
 
    @Column(name = "mcode")
    private String mcode;

	public LateChangesKey(int rId, String mcode) {
		super();
		RId = rId;
		this.mcode = mcode;
	}

	public LateChangesKey() {
		super();
	}

	public int getRId() {
		return RId;
	}

	public void setRId(int rId) {
		RId = rId;
	}

	public String getMcode() {
		return mcode;
	}

	public void setMcode(String mcode) {
		this.mcode = mcode;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + RId;
		result = prime * result + ((mcode == null) ? 0 : mcode.hashCode());
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
		LateChangesKey other = (LateChangesKey) obj;
		if (RId != other.RId)
			return false;
		if (mcode == null) {
			if (other.mcode != null)
				return false;
		} else if (!mcode.equals(other.mcode))
			return false;
		return true;
	}

	

	
}
