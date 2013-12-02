package com.java.deany.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Department {
	private int departmentId;
	private String departmentName;
	private Set groups = new HashSet();
	
	public Department() {
		// TODO Auto-generated constructor stub
	}
	
	public int getDepartmentId() {
		return this.departmentId;
	}
	
	public String getDepartmentName() {
		return this.departmentName;
	}
	
	public Set getGroups() {
		return this.groups;
	}
	
	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}
	
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	
	public void setGroups(Set groups) {
		this.groups = groups;
	}
	
	@Override
	public String toString() {
		return " Department:" + getDepartmentId() + "-" + getDepartmentName();
	}
}
