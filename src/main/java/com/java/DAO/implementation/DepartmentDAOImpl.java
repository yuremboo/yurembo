package com.java.DAO.implementation;

import static com.java.utils.HibernateUtil.getSessionFactory;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Projections;

import com.java.DAO.DepartmentDAO;
import com.java.deany.entity.Department;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DepartmentDAOImpl implements DepartmentDAO {

	static Logger log = LogManager.getLogger(DepartmentDAOImpl.class);
	@Override
	public void addDepartment(Department department) {
		// TODO Auto-generated method stub
		Session session = null;
		try {
			session = getSessionFactory().openSession();
			session.beginTransaction();
			session.save(department);
			session.getTransaction().commit();
			log.info("Added department: " + department);
		} catch (Exception e) {
			log.error("Error insert " + e);
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		
	}

	@Override
	public void updateDepartment(int departmentId, Department department) {
		// TODO Auto-generated method stub
		Session session = null;
		try {
			session = getSessionFactory().openSession();
			session.beginTransaction();
			Department departmentUpd = (Department)session.get(Department.class, departmentId);
			departmentUpd.setDepartmentName(department.getDepartmentName());
			session.update(departmentUpd);
			session.getTransaction().commit();
			log.info("Updateded department: " + department);
		} catch (Exception e) {
			log.error("Error insert " + e);
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
	}

	@Override
	public Collection<Department> getAllDepartments() {
		// TODO Auto-generated method stub
		Session session = null;
		List<Department> departments = new ArrayList<Department>();
		try {
			session = getSessionFactory().openSession();
			departments = session.createCriteria(Department.class).list();
			log.info("Got all departments ");
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
	public Department getDepartmentById(int departmentId) {
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
	public void deleteDepartment(Department department) {
		// TODO Auto-generated method stub
		Session session = null;
	    try {
	    	session = getSessionFactory().openSession();
	    	session.beginTransaction();
	    	session.delete(department);
	    	session.getTransaction().commit();
	    	log.info("Deleted department: " + department);
	    } catch (Exception e) {
	    	log.error(e);
	    } finally {
	      if (session != null && session.isOpen()) {
	        session.close();
	      }
	    }
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		Session session = null;
		int count = 0;
		try {
			session = getSessionFactory().getCurrentSession();
			session.beginTransaction();
			Object result = session.createCriteria(Department.class)
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
