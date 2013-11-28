package com.java.DAO.implementation;

import java.sql.SQLException;

import org.hibernate.Session;

import com.java.DAO.StudentDAO;
import com.java.deany.Student;
import com.java.deany.StudentsList;
import com.java.utils.HibernateUtil;

public class StudentDAOImpl implements StudentDAO {

	@Override
	public void addStudent(Student student) throws SQLException {
		// TODO Auto-generated method stub
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.save(student);
			session.getTransaction().commit();
		} catch (Exception e) {
			System.err.println("Error insert " + e);
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}

	}

	@Override
	public void updateStudent(int studentId, Student student)
			throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public StudentsList<Student> getAllStudents() throws SQLException {
		// TODO Auto-generated method stub
		Session session = null;
		StudentsList<Student> students = new StudentsList<Student>();
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			students.addAll(session.createCriteria(Student.class).list());
		} catch (Exception e) {
			System.err.println(e);
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return students;
	}

	@Override
	public Student getStudentById(int studentId) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteStudent(Student student) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public StudentsList<Student> getStudentsByGroup(int groupNumber)
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StudentsList<Student> getStudentsByMark(int averageMark)
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
