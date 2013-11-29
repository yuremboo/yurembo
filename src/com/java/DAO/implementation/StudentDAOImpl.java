package com.java.DAO.implementation;

import java.sql.SQLException;

import org.hibernate.Query;
import org.hibernate.Session;

import com.java.DAO.StudentDAO;
import com.java.deany.Group;
import com.java.deany.Student;
import com.java.deany.StudentsList;

import static com.java.utils.HibernateUtil.getSessionFactory;

public class StudentDAOImpl implements StudentDAO {

	@Override
	public void addStudent(Student student) throws SQLException {
		// TODO Auto-generated method stub
		Session session = null;
		try {
			session = getSessionFactory().openSession();
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
		Session session = null;
		try {
			session = getSessionFactory().openSession();
			session.beginTransaction();
			session.update(student);
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
	public StudentsList<Student> getAllStudents() throws SQLException {
		// TODO Auto-generated method stub
		Session session = null;
		StudentsList<Student> students = new StudentsList<Student>();
		try {
			session = getSessionFactory().openSession();
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
		Session session = null;
		Student student = null;
		try {
			session = getSessionFactory().openSession();
			student = (Student) session.load(Student.class, studentId);
		} catch (Exception e) {
			System.err.println(e);
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return student;
	}

	@Override
	public void deleteStudent(Student student) throws SQLException {
		// TODO Auto-generated method stub
		Session session = null;
	    try {
	    	session = getSessionFactory().openSession();
	    	session.beginTransaction();
	    	session.delete(student);
	    	session.getTransaction().commit();
	    } catch (Exception e) {
	    	System.err.println(e);
	    } finally {
	      if (session != null && session.isOpen()) {
	        session.close();
	      }
	    }

	}

	@Override
	public StudentsList<Student> getStudentsByGroup(Group group)
			throws SQLException {
		// TODO Auto-generated method stub
		Session session = null;
		StudentsList<Student> students = null;
		try {
			session = getSessionFactory().getCurrentSession();
			session.beginTransaction();
			int groupNumber = group.getGroupNumber();
			Query query = session.createQuery("from students where groupNumber = :groupNumber").setInteger("groupNumber", groupNumber);
			students = ((StudentsList<Student>) query.list());
			session.getTransaction().commit();
		} catch (Exception e) {
			System.err.println(e);
		} 
		return null;
	}

	@Override
	public StudentsList<Student> getStudentsByMark(int averageMark)
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
