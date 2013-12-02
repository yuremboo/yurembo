package com.java.deany.entity;

import java.util.HashSet;
import java.util.Set;

import com.java.deany.StudentsList;

public class Project {
	private int projectId;
	private String projectName;
	private Set students = new HashSet();
	
	public Project() {
		
	}
	
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	
	public void setStudents(Set students) {
		this.students = students;
	}
	
	public int getProjectId() {
		return this.projectId;
	}
	
	public String getProjectName() {
		return this.projectName;
	}
	
	public Set getStudents() {
		return this.students;
	}
	
	@Override
	public String toString() {
		return "Project:" + getProjectId() +"-" + getProjectName();
	}

}
