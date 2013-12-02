package com.java.DAO.implementation;

import static com.java.utils.HibernateUtil.getSessionFactory;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.hibernate.Session;

import com.java.DAO.DepartmentDAO;
import com.java.deany.Deany;
import com.java.deany.entity.Department;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DepartmentDAOImpl implements DepartmentDAO {

	static Logger log = LogManager.getLogger(DepartmentDAOImpl.class.getName());
	@Override
	public void addDepartment(Department department) throws SQLException {
		// TODO Auto-generated method stub
		Session session = null;
		try {
			session = getSessionFactory().openSession();
			session.beginTransaction();
			session.save(department);
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
	public void updateDepartment(int departmentId, Department department)
			throws SQLException {
		// TODO Auto-generated method stub
		Session session = null;
		try {
			session = getSessionFactory().openSession();
			session.beginTransaction();
			session.update(department);
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
	public Collection<Department> getAllDepartments() throws SQLException {
		// TODO Auto-generated method stub
		Session session = null;
		List<Department> departments = new ArrayList<Department>();
		try {
			session = getSessionFactory().openSession();
			departments = session.createCriteria(Department.class).list();
		} catch (Exception e) {
			log.error(e);
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return departments;
	}

	@Override
	public Department getDepartmentById(int departmentId) throws SQLException {
		// TODO Auto-generated method stub
		Session session = null;
		Department department = null;
		try {
			session = getSessionFactory().openSession();
			department = (Department) session.load(Department.class, departmentId);
		} catch (Exception e) {
			log.error(e);
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return department;
	}

	@Override
	public void deleteDepartment(Department department) throws SQLException {
		// TODO Auto-generated method stub
		Session session = null;
	    try {
	    	session = getSessionFactory().openSession();
	    	session.beginTransaction();
	    	session.delete(department);
	    	session.getTransaction().commit();
	    } catch (Exception e) {
	    	log.error(e);
	    } finally {
	      if (session != null && session.isOpen()) {
	        session.close();
	      }
	    }
	}
	
}
