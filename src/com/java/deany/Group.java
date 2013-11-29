package com.java.deany;

public class Group {
	private int groupNumber;
	private String groupName;
	private int cathedraId;
	private int curatorId;
	private StudentsList<Student> students = new StudentsList<Student>();
	
	/**
	 * 
	 */
	public Group() {
		
	}
	
	public void setGroupNumber(int groupNumber) {
		this.groupNumber = groupNumber;
	}
	
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	
	public void setCathedraId(int cathedraId) {
		this.cathedraId = cathedraId;
	}
	
	public void setCuratorId(int curatorId) {
		this.curatorId = curatorId;
	}
	
	public void setStudents(StudentsList<Student> students) {
		this.students = students;
	}
	
	public int getGroupNumber() {
		return this.groupNumber;
	}
	
	public String getGroupName() {
		return this.groupName;
	}
	
	public int getCathedraId() {
		return this.cathedraId;
	}
	
	public int getCuratorId() {
		return this.curatorId;
	}
	
	public StudentsList<Student> setStudents() {
		return this.students;
	}
}
