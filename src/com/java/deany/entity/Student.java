package com.java.deany.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

enum StudentsField { ID, FIRSTNAME, LASTNAME, MARK, GROUP, COURSE };
/**
 * @author yurembo
 */
public class Student implements Serializable {
	private static final long serialVersionUID = 1L;
	//private static final long serialVersionUID = 1L;
	private String lastName;
	private String firstName;
	private float averageMark;
	private int groupNumber;
	private int id;
	private Set projects = new HashSet();
	private static int ID = 1;
	public static String regExp = "(([\\d]*)[\\s][A-Z]{1}[a-z-]*[\\s][A-Z]{1}[a-z-]*[\\s][1-5]\\.[\\d][\\s][1-5][\\d]{2})";
	
	public Student() {
		
	}
	/**
	 * 
	 * @param lastName - last name of student. Type: String.
	 * @param firstName - first name of student. Type: String.
	 * @param averageMark - average mark of student. Type: double.
	 * @param groupNumber - number of student's group. Type: double.
	 */
	public Student(String lastName, 
			String firstName, 
			float averageMark, 
			int groupNumber) {
		this.lastName = lastName;
		this.firstName = firstName;
		this.averageMark = averageMark;
		this.groupNumber = groupNumber;
		this.id = ID++;
	}
	/**
	 * 
	 * @return Student's first name. Type: String.
	 */
	public String getFirstName() {
		return this.firstName;
	}
	/**
	 * 
	 * @return Student's ID. Type: int.
	 */
	public int getId() {
		return this.id;
	}
	/**
	 * 
	 * @return Student's last name. Type: String.
	 */
	public String getLastName() {
		return this.lastName;
	}
	/**
	 * 
	 * @return Student's average mark. Type: double.
	 */
	public float getAverageMark()	{
		return this.averageMark;
	}
	/**
	 * @return Student's group. Type: int.
	 */
	public int getGroupNumber() {
		return this.groupNumber;
	}
	
	public Set getProjects() {
		return this.projects;
	}
	
	public void setProjects(Set projects) {
		this.projects = projects;
	}
	/**
	 * @param group - Student's group. Type: int.
	 */
	public void setGroupNumber(int group)	{
		this.groupNumber = group;
	}
	/**
	 * 
	 * @param averageMark
	 */
	public void setAverageMark(float averageMark)	{
		this.averageMark = averageMark;
	}
	
	/**
	 * 
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * 
	 * @param id - Student's ID. Type: int.
	 */
	public static void setID(int id) {
		Student.ID = id;
	}
	/**
	 * 
	 * @param firstName - student's firstname
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * 
	 * @param lastName - student's lastname
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) {
			return false;
		}
		if (this.averageMark == ((Student) obj).getAverageMark()
				&& this.getGroupNumber() == ((Student) obj).getGroupNumber()
				&& this.getFirstName().equals(((Student) obj).getFirstName())
				&& this.getLastName().equals(((Student) obj).getLastName())) {
			return true;
		}
		return false;
	}    
	
	
	@Override 
	public int hashCode() {
		return this.id;
	}

	@Override
	public String toString() {
		return getId() + " " + getLastName() + " " + getFirstName() + " " + getAverageMark() + " " + getGroupNumber();
	}


}
