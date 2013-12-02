package com.java.deany.entity;

import java.util.HashSet;
import java.util.Set;

import com.java.deany.StudentsList;

public class Group {
	private int groupNumber;
	private int departmentId;
	private String curator;
	private Set students = new HashSet();
	
	/**
	 * 
	 */
	public Group() {
		
	}
	
	public void setGroupNumber(int groupNumber) {
		this.groupNumber = groupNumber;
	}
	
	public void setDepartmentId(int cathedraId) {
		this.departmentId = cathedraId;
	}
	
	public void setCurator(String curator) {
		this.curator = curator;
	}
	
	public void setStudents(Set students) {
		this.students = students;
	}
	
	public int getGroupNumber() {
		return this.groupNumber;
	}
	
	public String getCurator() {
		return this.curator;
	}
	
	public Set getStudents() {
		return this.students;
	}
	
	public int getDepartmentId() {
		return this.departmentId;
	}
	
	@Override
	public String toString() {
		return "Group:" + getGroupNumber() + " Department ID:" + getDepartmentId() + " Curator:" + getCurator();
	}
	
}
