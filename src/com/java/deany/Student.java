package com.java.deany;

import java.io.Serializable;


enum StudentsField {ID, FIRSTNAME, LASTNAME, MARK, GROUP, COURSE};

public class Student implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	//private static final long serialVersionUID = 1L;
	private String lastName;
	private String firstName;
	private double averageMark;
	private int groupNumber;
	private int id;
	private static int ID = 1;
	public static String regExp = "(([\\d]*)[\\s][A-Z]{1}[a-z-]*[\\s][A-Z]{1}[a-z-]*[\\s][1-5]\\.[\\d][\\s][1-5][\\d]{2})";
	
	public Student(String lastName, String firstName, double averageMark, int groungNumber)
	{
		this.lastName = lastName;
		this.firstName= firstName;
		this.averageMark = averageMark;
		this.groupNumber = groungNumber;
		this.id = ID;
		ID++;
	}
	
	public String getFirstName()
	{
		return this.firstName;
	}
	
	public int getId()
	{
		return this.id;
	}
	
	public String getLastName()
	{
		return this.lastName;
	}
	
	public double getAverageMark()
	{
		return this.averageMark;
	}
	
	public int getGroup()
	{
		return this.groupNumber;
	}
	
	public void setGroup(int group)
	{
		this.groupNumber = group;
	}
	
	@Override
	public String toString(){
		return getId() + " " + getLastName() + " " + getFirstName() + " " + getAverageMark() + " " + getGroup();
	}



}
