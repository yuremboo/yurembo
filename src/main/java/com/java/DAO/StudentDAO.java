package com.java.DAO;

import com.java.deany.*;
import com.java.deany.entity.Group;
import com.java.deany.entity.Project;
import com.java.deany.entity.Student;

public interface StudentDAO {
	void addStudent(Student student);
	void updateStudent(int studentId, Student student);
	StudentsList<Student> getAllStudents();
	Student getStudentById(int studentId);
	void deleteStudent(Student student);
	StudentsList<Student> getStudentsByGroup(Group group);
	StudentsList<Student> getStudentsByProject(Project project);
	StudentsList<Student> getStudentsByGroup(int groupNumber);
	StudentsList<Student> getStudentsByMark(float averageMark);
	int getCount();
}
