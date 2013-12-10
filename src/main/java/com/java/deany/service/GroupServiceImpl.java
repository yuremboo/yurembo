package com.java.deany.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.DAO.GroupDAO;
import com.java.deany.Factory;
import com.java.deany.entity.Department;
import com.java.deany.entity.Group;

@Service
public class GroupServiceImpl implements GroupService {

	private GroupDAO groupDAO = Factory.getInstance().getGroupDAO();

	@Override
	public void addGroup(Group group) {
		// TODO Auto-generated method stub
		groupDAO.addGroup(group);
	}

	@Override
	public void updateGroup(int groupNumber, Group group) {
		// TODO Auto-generated method stub
		groupDAO.updateGroup(groupNumber, group);
	}

	@Override
	public Collection<Group> getAllGroups() {
		// TODO Auto-generated method stub
		return groupDAO.getAllGroups();
	}

	@Override
	public Group getGroupByNumber(int groupNumber) {
		// TODO Auto-generated method stub
		return groupDAO.getGroupByNumber(groupNumber);
	}

	@Override
	public void deleteGroup(Group group) {
		// TODO Auto-generated method stub
		groupDAO.deleteGroup(group);
	}

	@Override
	public Collection<Group> getGroupsByDepartment(Department department) {
		// TODO Auto-generated method stub
		return groupDAO.getGroupsByDepartment(department);
	}

}
