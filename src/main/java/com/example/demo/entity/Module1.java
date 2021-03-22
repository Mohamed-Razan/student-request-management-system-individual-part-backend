package com.example.demo.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class Module1 {

	@Id
	private String mcode;
	private String mtitle;
	private int credit;
	private String dep;
	
	@OneToMany(mappedBy = "module")
    private List<LateChanges> lateModuleChangeRequest;
	
	@OneToMany(mappedBy = "module")
    private List<LateChanges> alterModuleRequest;

	public Module1(String mcode, String mtitle, int credit, String dep) {
		super();
		this.mcode = mcode;
		this.mtitle = mtitle;
		this.credit = credit;
		this.dep = dep;
	}

	public Module1() {
		super();
	}

	public String getMcode() {
		return mcode;
	}

	public void setMcode(String mcode) {
		this.mcode = mcode;
	}

	public String getMtitle() {
		return mtitle;
	}

	public void setMtitle(String mtitle) {
		this.mtitle = mtitle;
	}

	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}

	public String getDep() {
		return dep;
	}

	public void setDep(String dep) {
		this.dep = dep;
	}
	
}
