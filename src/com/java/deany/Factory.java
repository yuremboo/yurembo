package com.java.deany;

import com.java.DAO.DepartmentDAO;
import com.java.DAO.GroupDAO;
import com.java.DAO.ProjectDAO;
import com.java.DAO.StudentDAO;
import com.java.DAO.implementation.DepartmentDAOImpl;
import com.java.DAO.implementation.GroupDAOImpl;
import com.java.DAO.implementation.ProjectDAOImpl;
import com.java.DAO.implementation.StudentDAOImpl;

public class Factory {
	private static StudentDAO studentDAO = null;
	private static GroupDAO groupDAO = null;
	private static DepartmentDAO departmentDAO = null;
	private static ProjectDAO projectDAO = null;
	//private static Factory instance = null;
	
	/*
	public static synchronized Factory getInstance() {
		if (instance == null) {
			instance = new Factory();
		}
		return instance;
	}*/
	
	public static StudentDAO getStudentDAO() {
		if (studentDAO == null) {
			studentDAO = new StudentDAOImpl();
		}
		return studentDAO;
	}
	
	public static GroupDAO getGroupDAO() {
		if (groupDAO == null) {
			groupDAO = new GroupDAOImpl();
		}
		return groupDAO;
	}
	
	public static DepartmentDAO getDepartmentDAO() {
		if (departmentDAO == null) {
			departmentDAO = new DepartmentDAOImpl();
		}
		return departmentDAO;
	}
	
	public static ProjectDAO getProjectDAO() {
		if (projectDAO == null) {
			projectDAO = new ProjectDAOImpl();
		}
		return projectDAO;
	}
}
