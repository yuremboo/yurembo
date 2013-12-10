package com.java.deany;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import com.java.deany.entity.Department;
import com.java.deany.entity.Group;
import com.java.deany.entity.Project;
import com.java.deany.entity.Student;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Deany {
	
	/*
    private static Connection con = null;
    private static final String username = "root";
    private static final String password = "root";
    private static final String URL = "jdbc:mysql://localhost:3306/deanery";
*/
	StudentsList<Student> students = new StudentsList<>();
        public final String serializedFile = "students.out";
        public final String textFile = "students.txt";
        public final String xmlFile = "students.xml";

	public static void main(String[] args) {
		// TODO Auto-generated method stub

			new Deany();


	}

	public Deany() {

		
		Logger log = LogManager.getLogger(Deany.class.getName());

		Factory.getInstance().getStudentDAO().updateStudent(12, new Student("asda", "asdasd", 5.2f, 521));
		
		students = Factory.getInstance().getStudentDAO().getAllStudents();
		for (Student s:students) {
			System.out.println(s); //print all students
		}
		
		
		//Group g = new Group();
		Collection groups = Factory.getInstance().getDepartmentDAO().getDepartmentById(2).getGroups();
		System.out.println("Groups by Dep2");
		Iterator iterator = groups.iterator();
		Group gg = null;
		while (iterator.hasNext()) {
			Group group = (Group) iterator.next();
			System.out.println(group);
			if (group.getGroupNumber() == 541) gg = group;
		}
		
		StudentsList<Student> sl = new StudentsList<>();
		sl.addAll(gg.getStudents());
		for (Student s:sl) {
			System.out.println(s); //print all students
		}
		
		Collection departments = Factory.getInstance().getDepartmentDAO().getAllDepartments();
		iterator = departments.iterator();
		while (iterator.hasNext()) {
			Department dep = (Department) iterator.next();
			System.out.println(dep);
		}
		
		
		Project project = new Project();
		
		
		Factory.getInstance().getProjectDAO().deleteProject(Factory.getInstance().getProjectDAO().getProjectById(7));
		
		Collection projects = Factory.getInstance().getProjectDAO().getAllProjects();
		ArrayList<Project> stproj = new ArrayList<Project>();
		iterator = projects.iterator();
		boolean t = true;
		while (iterator.hasNext()) {
			project = (Project) iterator.next();
			if (t) stproj.add(project);
			t = false;
			System.out.println(project);
		}
		
		System.out.println(Factory.getInstance().getGroupDAO().getGroupByNumber(521));
		

		log.trace("Exiting application."); 

	}
}
