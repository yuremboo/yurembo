package com.java.DAO;

import java.sql.SQLException;
import java.util.Collection;

import com.java.deany.Group;
import com.java.deany.Student;
import com.java.deany.StudentsList;

public interface GroupDAO {
	void addGroup(Group group) throws SQLException;
	void updateGroup(int groupId, Group group) throws SQLException;
	Collection getAllGroups() throws SQLException;
	Group getGroupById(int groupId) throws SQLException;
	void deleteGroup(Group group) throws SQLException;
	Collection getGroupsByCathedra(/*Cathedra cathedra*/) throws SQLException;
	Collection getGroupsByMark(int averageMark) throws SQLException;

}
