package com.java.deany.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.java.DAO.StudentDAO;
import com.java.deany.Factory;
import com.java.deany.StudentsList;
import com.java.deany.entity.Group;
import com.java.deany.entity.Project;
import com.java.deany.entity.Student;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentDAO studentDAO;

	@Override
	public void addStudent(Student student) throws SQLException {
		// TODO Auto-generated method stub
		studentDAO.addStudent(student);
	}

	@Override
	public void updateStudent(int studentId, Student student) throws SQLException {
		// TODO Auto-generated method stub
		studentDAO.updateStudent(studentId, student);
	}

	@Override
	public StudentsList<Student> getAllStudents() throws SQLException {
		// TODO Auto-generated method stub
		return Factory.getInstance().getStudentDAO().getAllStudents();
	}

	@Override
	public Student getStudentById(int studentId) throws SQLException {
		// TODO Auto-generated method stub
		return studentDAO.getStudentById(studentId);
	}

	@Override
	public void deleteStudent(Student student) throws SQLException {
		// TODO Auto-generated method stub
		studentDAO.deleteStudent(student);
	}

	@Override
	public StudentsList<Student> getStudentsByGroup(Group group) throws SQLException {
		// TODO Auto-generated method stub
		return studentDAO.getStudentsByGroup(group);
	}

	@Override
	public StudentsList<Student> getStudentsByProject(Project project) throws SQLException {
		// TODO Auto-generated method stub
		return studentDAO.getStudentsByProject(project);
	}

	@Override
	public StudentsList<Student> getStudentsByGroup(int groupNumber) throws SQLException {
		// TODO Auto-generated method stub
		return studentDAO.getStudentsByGroup(groupNumber);
	}

	@Override
	public StudentsList<Student> getStudentsByMark(float averageMark) throws SQLException {
		// TODO Auto-generated method stub
		return studentDAO.getStudentsByMark(averageMark);
	}

	@Override
	public int getCount() throws SQLException {
		// TODO Auto-generated method stub
		return studentDAO.getCount();
	}

}
