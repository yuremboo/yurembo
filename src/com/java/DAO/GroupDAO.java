package com.java.DAO;

import java.sql.SQLException;
import java.util.Collection;

import com.java.deany.entity.Department;
import com.java.deany.entity.Group;

public interface GroupDAO {
	void addGroup(Group group) throws SQLException;
	void updateGroup(int groupNumber, Group group) throws SQLException;
	Collection<Group> getAllGroups() throws SQLException;
	Group getGroupByNumber(int groupNumber) throws SQLException;
	void deleteGroup(Group group) throws SQLException;
	Collection<Group> getGroupsByDepartment(Department department) throws SQLException;
}
