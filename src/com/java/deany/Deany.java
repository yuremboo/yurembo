package com.java.deany;
import java.sql.*;

import org.hibernate.Session;

import com.java.DAO.StudentDAO;
import com.java.DAO.implementation.StudentDAOImpl;

public class Deany {
	
    private static Connection con = null;
    private static final String username = "root";
    private static final String password = "root";
    private static final String URL = "jdbc:mysql://localhost:3306/deanery";

	StudentsList<Student> students = new StudentsList<>();
        public final String serializedFile = "students.out";
        public final String textFile = "students.txt";
        public final String xmlFile = "students.xml";
        //public static String regExp = "(([\\d]*)[\\s][A-Z]{1}[a-z-]*[\\s][A-Z]{1}[a-z-]*[\\s][1-5]\\.[\\d][\\s][1-5][\\d]{2})";
        
        	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			new Deany();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Deany() throws SQLException {
		//Factory.getInstance();
		//StudentDAOImpl studentDAOImpl = new StudentDAOImpl();
		students = Factory.getStudentDAO().getAllStudents();
		for (Student s:students) {
			System.out.println(s); //print all students
		}
		Student stud = null;
		stud = Factory.getStudentDAO().getStudentById(3);
		
		System.out.println(stud);
		
		//DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		//con = DriverManager.getConnection(URL, username, password);
        
       // if(con!=null) System.out.println("OK! \n");
       // if(con==null) System.exit(0);

		//students.deserializeStudentsList(serializedFile);  //Serialization 
		//students.loadFromFile(textFile); 
		//students.loadFromXml(xmlFile);
		//students.add(new Student("Test","Test",2.5,141)); //add new student
		
		
		/* 
		Student newStudent = new Student();
		newStudent.setFirstName("Petro");
		newStudent.setLastName("Petrov");
		newStudent.setAverageMark(4);
		newStudent.setGroupNumber(141);
		Factory.getStudentDAO().addStudent(newStudent);
		students = Factory.getStudentDAO().getAllStudents();
		for (Student s:students) {
			System.out.println(s); //print all students
		}
		*/
		
		//students.orderBy(StudentsField.LASTNAME);  //sorting students list
		//for (Student s:students) {
		//	System.out.println(s); //print all students
		//}
		
		/*
		 * overloaded method StudentsList<E> getStudentsBy(StudentsField field, Character operator, Double i)
		 * 					 StudentsList<E> getStudentsBy(StudentsField field, Character operator, int i)
		 */
		
		//StudentsList<Student> studentsBy = new StudentsList<>();
		//studentsBy.addAll(students.getStudentsBy(StudentsField.MARK,'>',4.0));
		
		//for (Student s:studentsBy) {
		//	System.out.println(s); //print all studentsBy
		//}
		
		//students.saveToFile(textFile);  //Save to file
		//students.serializeStudentsList(serializedFile);  //Serialization
		//students.saveToXml(xmlFile);
                
		
       // if (con!=null)con.close();
	}
}
