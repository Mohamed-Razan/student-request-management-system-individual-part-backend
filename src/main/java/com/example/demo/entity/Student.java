package com.example.demo.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;


import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@Entity
@Table
@PrimaryKeyJoinColumn
@SuperBuilder
public class Student extends User {
	
	private String indexNo;
    private String courseTitle;
    private String levelSemester;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "std")
	private List<Request> requests;

	public Student(String userName, String userEmail, String userPasswordHashed, String contactNo, String indexNo,
			String courseTitle, String levelSemester) {
		super(userName, userEmail, userPasswordHashed, contactNo);
		this.indexNo = indexNo;
		this.courseTitle = courseTitle;
		this.levelSemester = levelSemester;
	}

	public Student(String userName, String userEmail, String userPasswordHashed, String contactNo) {
		super(userName, userEmail, userPasswordHashed, contactNo);
	}
	
	public Student() {
		super();
	}

	public String getIndexNo() {
		return indexNo;
	}

	public void setIndexNo(String indexNo) {
		this.indexNo = indexNo;
	}

	public String getCourseTitle() {
		return courseTitle;
	}

	public void setCourseTitle(String courseTitle) {
		this.courseTitle = courseTitle;
	}

	public String getLevelSemester() {
		return levelSemester;
	}

	public void setLevelSemester(String levelSemester) {
		this.levelSemester = levelSemester;
	}
}
