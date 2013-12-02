package com.java.DAO.implementation;

import static com.java.utils.HibernateUtil.getSessionFactory;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;

import com.java.DAO.ProjectDAO;
import com.java.deany.entity.Project;
import com.java.deany.entity.Student;

public class ProjectDAOImpl implements ProjectDAO {
	
	static Logger log = LogManager.getLogger(ProjectDAOImpl.class.getName());

	@Override
	public void addProject(Project project) throws SQLException {
		// TODO Auto-generated method stub
		Session session = null;
		try {
			session = getSessionFactory().openSession();
			session.beginTransaction();
			session.save(project);
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
	public void updateProject(int projectId, Project project)
			throws SQLException {
		// TODO Auto-generated method stub
		Session session = null;
		try {
			session = getSessionFactory().openSession();
			session.beginTransaction();
			session.update(project);
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
	public Collection<Project> getAllProjects() throws SQLException {
		// TODO Auto-generated method stub
		Session session = null;
		List<Project> projects = new ArrayList<Project>();
		try {
			session = getSessionFactory().openSession();
			projects = session.createCriteria(Project.class).list();
		} catch (Exception e) {
			log.error(e);
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return projects;
	}

	@Override
	public Project getProjectById(int projectId) throws SQLException {
		// TODO Auto-generated method stub
		Session session = null;
		Project project = null;
		try {
			session = getSessionFactory().openSession();
			project = (Project) session.load(Project.class, projectId);
		} catch (Exception e) {
			log.error(e);
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return project;
	}

	@Override
	public void deleteProject(Project project) throws SQLException {
		// TODO Auto-generated method stub
		Session session = null;
	    try {
	    	session = getSessionFactory().openSession();
	    	session.beginTransaction();
	    	session.delete(project);
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
	public Collection<Project> getProjectsByStudent(Student student)
			throws SQLException {
		// TODO Auto-generated method stub
		Session session = null;
		List<Project> projects = new ArrayList<Project>();
		try {
			session = getSessionFactory().getCurrentSession();
			session.beginTransaction();
			int id = student.getId();
			Query query = session.createQuery(
					" select P " 
							+ " from Project P INNER JOIN P.students student" 
							+ " where student.id = :id "
							).setInteger("id", id);
			projects = query.list();
			session.getTransaction().commit();
		} catch (Exception e) {
			log.error(e);
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return projects;
	}

}
