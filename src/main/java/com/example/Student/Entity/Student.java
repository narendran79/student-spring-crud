package com.example.Student.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="student_002")
public class Student {

	@Id
	private Integer rollNo;
	private String name;
	private String department;
	private Integer collegeId;
	
	public  Student() {
		
	}

	public Student(Integer rollNo, String name, String department, Integer collegeId) {
		super();
		this.rollNo = rollNo;
		this.name = name;
		this.department = department;
		this.collegeId = collegeId;
	}

	public Integer getRollNo() {
		return rollNo;
	}

	public void setRollNo(Integer rollNo) {
		this.rollNo = rollNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public Integer getCollegeId() {
		return collegeId;
	}

	public void setCollegeId(Integer collegeId) {
		this.collegeId = collegeId;
	}
}
