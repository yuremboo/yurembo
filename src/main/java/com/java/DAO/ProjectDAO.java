package com.java.DAO;

import java.util.Collection;

import com.java.deany.entity.Project;
import com.java.deany.entity.Student;

public interface ProjectDAO {
	void addProject(Project project);
	void updateProject(int projectId, Project project);
	Collection<Project> getAllProjects();
	Project getProjectById(int projectId);
	void deleteProject(Project project);
	Collection<Project> getProjectsByStudent(Student student);
	//Collection getGroupsByMark(int averageMark) throws SQLException;
	int getCount();

}
