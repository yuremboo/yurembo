package com.java.deany.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="groups")
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
	
	@Id
	@Column(name="groupNumber")
	public int getGroupNumber() {
		return this.groupNumber;
	}
	
	@Column(name="curator")
	public String getCurator() {
		return this.curator;
	}
	
	@OneToMany(fetch=FetchType.EAGER)
	@JoinColumn(name="groupNumber")
	public Set<Student> getStudents() {
		return this.students;
	}
	
	@Column(name="departmentId")
	public int getDepartmentId() {
		return this.departmentId;
	}
	
	@Override
	public String toString() {
		return "Group:" + getGroupNumber() + " Department ID:" + getDepartmentId() + " Curator:" + getCurator();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) {
			return false;
		}
		if (this.groupNumber == (((Group) obj).groupNumber)
				&& this.departmentId == (((Group) obj).departmentId)
				&& this.curator.equals(((Group) obj).curator)) {
			return true;
		}
		return false;
	}    
	
	
	@Override 
	public int hashCode() {
		return this.groupNumber;
	}
	
}
