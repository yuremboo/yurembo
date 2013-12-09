package com.java.deany.service;

import java.sql.SQLException;

import com.java.deany.StudentsList;
import com.java.deany.entity.Group;
import com.java.deany.entity.Project;
import com.java.deany.entity.Student;

public interface StudentService {
	void addStudent(Student student) throws SQLException;
	void updateStudent(int studentId, Student student) throws SQLException;
	StudentsList<Student> getAllStudents() throws SQLException;
	Student getStudentById(int studentId) throws SQLException;
	void deleteStudent(Student student) throws SQLException;
	StudentsList<Student> getStudentsByGroup(Group group) throws SQLException;
	StudentsList<Student> getStudentsByProject(Project project) throws SQLException;
	StudentsList<Student> getStudentsByGroup(int groupNumber) throws SQLException;
	StudentsList<Student> getStudentsByMark(float averageMark) throws SQLException;
	int getCount() throws SQLException;
}
