package com.java.DAO.implementation;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.java.DAO.StudentDAO;
import com.java.deany.StudentsList;
import com.java.deany.entity.Group;
import com.java.deany.entity.Project;
import com.java.deany.entity.Student;

import static com.java.utils.HibernateUtil.getSessionFactory;

public class StudentDAOImpl implements StudentDAO {
	
	static Logger log = LogManager.getLogger(StudentDAOImpl.class.getName());

	@Override
	public void addStudent(Student student) {
		// TODO Auto-generated method stub
		Session session = null;
		try {
			session = getSessionFactory().openSession();
			session.beginTransaction();
			session.save(student);
			session.getTransaction().commit();
			log.info("Added new student: " + student);
		} catch (Exception e) {
			log.error("Error insert " + e);
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}

	}

	
	
	@Override
	public void updateStudent(int id, Student student) {
		// TODO Auto-generated method stub
		Session session = null;
		try {
			session = getSessionFactory().openSession();
			session.beginTransaction();
			Student student2 = (Student)session.get(Student.class, id);
			student2.setFirstName(student.getFirstName());
			student2.setAverageMark(student.getAverageMark());
			student2.setGroupNumber(student.getGroupNumber());
			student2.setLastName(student.getLastName());
			
			session.update(student2);
			session.getTransaction().commit();
			log.info("Updated student: " + student);
		} catch (Exception e) {
			log.error("Error insert " + e);
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
	}

	@Override
	public StudentsList<Student> getAllStudents() {
		// TODO Auto-generated method stub
		Session session = null;
		StudentsList<Student> students = new StudentsList<Student>();
		try {
			session = getSessionFactory().openSession();
			students.addAll(session.createCriteria(Student.class).list());
			log.info("Read all students.");
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
	public Student getStudentById(int studentId) {
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
	public void deleteStudent(Student student) {
		// TODO Auto-generated method stub
		Session session = null;
	    try {
	    	session = getSessionFactory().openSession();
	    	session.beginTransaction();
	    	session.delete(student);
	    	session.getTransaction().commit();
	    	log.info("Deleted student: " + student);
	    } catch (Exception e) {
	    	log.error(e);
	    } finally {
	      if (session != null && session.isOpen()) {
	        session.close();
	      }
	    }

	}

	@Override
	public StudentsList<Student> getStudentsByGroup(Group group) {
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
	public StudentsList<Student> getStudentsByMark(float averageMark) {
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
	public StudentsList<Student> getStudentsByGroup(int groupNumber) {
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
	public StudentsList<Student> getStudentsByProject(Project project) {
		// TODO Auto-generated method stub
		Session session = null;
		StudentsList<Student> students = new StudentsList<Student>();
		try {
			session = getSessionFactory().openSession();
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



	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		Session session = null;
		int count = 0;
		try {
			session = getSessionFactory().getCurrentSession();
			session.beginTransaction();
			Object result = session.createCriteria(Student.class)
					.setProjection(Projections.rowCount()).uniqueResult();
			count = Integer.parseInt(result.toString());
			//session.getTransaction().commit();
		} catch (Exception e) {
			log.error(e);
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return count;
	}

}
