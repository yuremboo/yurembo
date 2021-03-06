package com.java.DAO;

import java.util.Collection;

import com.java.deany.entity.Department;
import com.java.deany.entity.Group;

public interface GroupDAO {
	void addGroup(Group group);
	void updateGroup(int groupNumber, Group group);
	Collection<Group> getAllGroups();
	Group getGroupByNumber(int groupNumber);
	void deleteGroup(Group group);
	Collection<Group> getGroupsByDepartment(Department department);
}
