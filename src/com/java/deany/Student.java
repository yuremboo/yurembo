package com.java.deany;

import java.io.Serializable;


enum StudentsField {ID, FIRSTNAME, LASTNAME, MARK, GROUP, COURSE};
/**
 * @author yurembo
 */
public class Student implements Serializable{

	private static final long serialVersionUID = 1L;
	//private static final long serialVersionUID = 1L;
	private String lastName;
	private String firstName;
	private double averageMark;
	private int groupNumber;
	private int id;
	private static int ID = 1;
	public static String regExp = "(([\\d]*)[\\s][A-Z]{1}[a-z-]*[\\s][A-Z]{1}[a-z-]*[\\s][1-5]\\.[\\d][\\s][1-5][\\d]{2})";
	/**
	 * 
	 * @param lastName - last name of student. Type: String.
	 * @param firstName - first name of student. Type: String.
	 * @param averageMark - average mark of student. Type: double.
	 * @param groupNumber - number of student's group. Type: double.
	 */
	public Student(String lastName, String firstName, double averageMark, int groupNumber)
	{
		this.lastName = lastName;
		this.firstName= firstName;
		this.averageMark = averageMark;
		this.groupNumber = groupNumber;
		this.id = ID;
		ID++;
	}
	/**
	 * 
	 * @return Student's first name. Type: String.
	 */
	public String getFirstName()
	{
		return this.firstName;
	}
	/**
	 * 
	 * @return Student's ID. Type: int.
	 */
	public int getId()
	{
		return this.id;
	}
	/**
	 * 
	 * @return Student's last name. Type: String.
	 */
	public String getLastName()
	{
		return this.lastName;
	}
	/**
	 * 
	 * @return Student's average mark. Type: double.
	 */
	public double getAverageMark()
	{
		return this.averageMark;
	}
	/**
	 * 
	 * @return Student's group. Type: int.
	 */
	public int getGroup()
	{
		return this.groupNumber;
	}
	/**
	 * 
	 * @param group - Student's group. Type: int.
	 */
	public void setGroup(int group)
	{
		this.groupNumber = group;
	}
	
	/**
	 * 
	 * @param ID - Student's ID. Type: int.
	 */
	public static void setID(int ID)
	{
		Student.ID = ID;
	}
	
	@Override
	public boolean equals(Object obj){
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) {
			return false;
		}
		if (this.averageMark == ((Student)obj).getAverageMark() && 
				this.getGroup() == ((Student)obj).getGroup() && 
				this.getFirstName().equals(((Student)obj).getFirstName()) &&
				this.getLastName().equals(((Student)obj).getLastName()))
		{
			return true;
		}
		return false;
	}    

	@Override
	public String toString(){
		return getId() + " " + getLastName() + " " + getFirstName() + " " + getAverageMark() + " " + getGroup();
	}


}
