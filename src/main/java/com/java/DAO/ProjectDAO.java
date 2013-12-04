package com.java.DAO;

import java.sql.SQLException;
import java.util.Collection;

import com.java.deany.entity.Project;
import com.java.deany.entity.Student;

public interface ProjectDAO {
	void addProject(Project project) throws SQLException;
	void updateProject(int projectId, Project project) throws SQLException;
	Collection<Project> getAllProjects() throws SQLException;
	Project getProjectById(int projectId) throws SQLException;
	void deleteProject(Project project) throws SQLException;
	Collection<Project> getProjectsByStudent(Student student) throws SQLException;
	//Collection getGroupsByMark(int averageMark) throws SQLException;
	int getCount() throws SQLException;

}
