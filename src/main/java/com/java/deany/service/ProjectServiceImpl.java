package com.java.deany.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.DAO.ProjectDAO;
import com.java.deany.Factory;
import com.java.deany.entity.Project;
import com.java.deany.entity.Student;

@Service
public class ProjectServiceImpl implements ProjectService {

	private ProjectDAO projectDAO = Factory.getInstance().getProjectDAO();

	@Override
	public void addProject(Project project) {
		// TODO Auto-generated method stub
		projectDAO.addProject(project);
	}

	@Override
	public void updateProject(int projectId, Project project) {
		// TODO Auto-generated method stub
		projectDAO.updateProject(projectId, project);
	}

	@Override
	public Collection<Project> getAllProjects() {
		// TODO Auto-generated method stub
		return projectDAO.getAllProjects();
	}

	@Override
	public Project getProjectById(int projectId) {
		// TODO Auto-generated method stub
		return projectDAO.getProjectById(projectId);
	}

	@Override
	public void deleteProject(Project project) {
		// TODO Auto-generated method stub
		projectDAO.deleteProject(project);
	}

	@Override
	public Collection<Project> getProjectsByStudent(Student student) {
		// TODO Auto-generated method stub
		return projectDAO.getProjectsByStudent(student);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return projectDAO.getCount();
	}

}
