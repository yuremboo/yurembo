package com.java.DAO;

import java.sql.SQLException;

import com.java.deany.*;
import com.java.utils.*;

public interface StudentDAO {
	public void addStudent(Student student) throws SQLException;
	public void updateStudent(int studentId, Student student) throws SQLException;
	public StudentsList<Student> getAllStudents() throws SQLException;
	public Student getStudentById(int studentId) throws SQLException;
	public void deleteStudent(Student student) throws SQLException;
	public StudentsList<Student> getStudentsByGroup(int groupNumber) throws SQLException;
	public StudentsList<Student> getStudentsByMark(int averageMark) throws SQLException;
}
