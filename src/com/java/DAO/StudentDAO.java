package com.java.DAO;

import java.sql.SQLException;

import com.java.deany.*;
import com.java.utils.*;

public interface StudentDAO {
	void addStudent(Student student) throws SQLException;
	void updateStudent(int studentId, Student student) throws SQLException;
	StudentsList<Student> getAllStudents() throws SQLException;
	Student getStudentById(int studentId) throws SQLException;
	void deleteStudent(Student student) throws SQLException;
	StudentsList<Student> getStudentsByGroup(int groupNumber) throws SQLException;
	StudentsList<Student> getStudentsByMark(int averageMark) throws SQLException;
}
