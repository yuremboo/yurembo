package com.java.DAO.implementation;

import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.java.DAO.StudentDAO;
import com.java.deany.Deany;
import com.java.deany.StudentsList;
import com.java.deany.entity.Group;
import com.java.deany.entity.Project;
import com.java.deany.entity.Student;

import static com.java.utils.HibernateUtil.getSessionFactory;

public class StudentDAOImpl implements StudentDAO {
	
	static Logger log = LogManager.getLogger(Deany.class.getName());

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
			log.error("Error insert " + e);
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
			log.error("Error insert " + e);
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
			log.error(e);
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
			log.error(e);
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
	    	log.error(e);
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
		StudentsList<Student> students = new StudentsList<Student>();
		try {
			session = getSessionFactory().getCurrentSession();
			session.beginTransaction();
			int groupNumber = group.getGroupNumber();
			Query query = session.createQuery("from Student S where S.groupNumber = " + groupNumber);
			students.addAll(query.list());
			session.getTransaction().commit();
		} catch (Exception e) {
			log.error(e);
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return students;
	}

	@Override
	public StudentsList<Student> getStudentsByMark(float averageMark)
			throws SQLException {
		// TODO Auto-generated method stub
		Session session = null;
		StudentsList<Student> students = new StudentsList<Student>();
		try {
			session = getSessionFactory().openSession();
			students.addAll(session.createCriteria(Student.class).add(Restrictions.eq("averageMark", averageMark)).list());
			//student = (Student) session.load(Student.class, averageMark);
		} catch (Exception e) {
			log.error(e);
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return students;
	}



	@Override
	public StudentsList<Student> getStudentsByGroup(int groupNumber)
			throws SQLException {
		// TODO Auto-generated method stub
		Session session = null;
		StudentsList<Student> students = new StudentsList<Student>();
		String query = "SELECT id, lastName, firstName, averageMark, groupNumber FROM students WHERE groupNumber = " + groupNumber;
		try {
			session = getSessionFactory().openSession();
			students.addAll(session.createSQLQuery(query).addEntity(Student.class).list());
		} catch (Exception e) {
			log.error(e);
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return students;
	}



	@Override
	public StudentsList<Student> getStudentsByProject(Project project)
			throws SQLException {
		// TODO Auto-generated method stub
		Session session = null;
		StudentsList<Student> students = new StudentsList<Student>();
		try {
			session = getSessionFactory().getCurrentSession();
			session.beginTransaction();
			int projectId = project.getProjectId();
			Query query = session.createQuery(
					" select S " 
							+ " from Student S INNER JOIN S.projects project" 
							+ " where project.id = :projectId "
							).setInteger("projectId", projectId);
			students.addAll(query.list());
			session.getTransaction().commit();
		} catch (Exception e) {
			log.error(e);
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return students;
	}

}
