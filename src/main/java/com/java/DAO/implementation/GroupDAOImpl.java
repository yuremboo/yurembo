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

import com.java.DAO.GroupDAO;
import com.java.deany.entity.Department;
import com.java.deany.entity.Group;


public class GroupDAOImpl implements GroupDAO {
	
	static Logger log = LogManager.getLogger(GroupDAOImpl.class.getName());

	@Override
	public void addGroup(Group group) {
		// TODO Auto-generated method stub
		Session session = null;
		try {
			session = getSessionFactory().openSession();
			session.beginTransaction();
			session.save(group);
			session.getTransaction().commit();
			log.info("Added group: " + group);
		} catch (Exception e) {
			log.error("Error insert " + e);
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
	}

	@Override
	public void updateGroup(int groupId, Group group) {
		// TODO Auto-generated method stub
		Session session = null;
		try {
			session = getSessionFactory().openSession();
			session.beginTransaction();
			session.update(group);
			session.getTransaction().commit();
			log.info("Updated group: " + group);
		} catch (Exception e) {
			log.error("Error insert " + e);
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
	}

	@Override
	public Collection<Group> getAllGroups() {
		// TODO Auto-generated method stub
		Session session = null;
		List<Group> groups = new ArrayList<Group>();
		try {
			session = getSessionFactory().openSession();
			groups = session.createCriteria(Group.class).list();
			log.info("Got all groups ");
		} catch (Exception e) {
			log.error(e);
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return groups;
	}

	@Override
	public Group getGroupByNumber(int groupNumber) {
		// TODO Auto-generated method stub
		Session session = null;
		Group group = null;
		try {
			session = getSessionFactory().openSession();
			group = (Group) session.load(Group.class, groupNumber);
		} catch (Exception e) {
			log.error(e);
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return group;
	}

	@Override
	public void deleteGroup(Group group) {
		// TODO Auto-generated method stub
		Session session = null;
	    try {
	    	session = getSessionFactory().openSession();
	    	session.beginTransaction();
	    	session.delete(group);
	    	session.getTransaction().commit();
	    	log.info("Deleted group: " + group);
	    } catch (Exception e) {
	    	log.error(e);
	    } finally {
	      if (session != null && session.isOpen()) {
	        session.close();
	      }
	    }
	}

	@Override
	public Collection<Group> getGroupsByDepartment(Department department) {
		// TODO Auto-generated method stub
		Session session = null;
		List<Group> groups = new ArrayList<Group>();
		try {
			session = getSessionFactory().getCurrentSession();
			session.beginTransaction();
			int departmentId = department.getDepartmentId();
			Query query = session.createQuery("from Group G where G.departmentId = " + departmentId);
			groups = query.list();
			session.getTransaction().commit();
		} catch (Exception e) {
			log.error(e);
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return groups;
	}
	
}
