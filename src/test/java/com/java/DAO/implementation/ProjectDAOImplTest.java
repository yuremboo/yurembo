package com.java.DAO.implementation;

import java.sql.SQLException;
import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

import com.java.deany.Factory;
import com.java.deany.entity.Project;

public class ProjectDAOImplTest extends Assert{
	Project project = new Project();
  @BeforeClass
  public void beforeClass() {
	  project.setProjectId(0);
	  project.setProjectName("Test project");
  }

  @AfterClass
  public void afterClass() {
	  project = null;
  }

  @BeforeTest
  public void beforeTest() {
  }

  @AfterTest
  public void afterTest() {
  }


  @Test
  public void addProject() throws SQLException {
	  ArrayList<Project> expected = new ArrayList<Project>();
	  expected.addAll(Factory.getProjectDAO().getAllProjects());
	  expected.add(project);
	  Factory.getProjectDAO().addProject(project);
	  ArrayList<Project> actual = new ArrayList<Project>();
	  actual.addAll(Factory.getProjectDAO().getAllProjects());
	  Factory.getProjectDAO().getAllProjects();
	  assertEquals(actual, expected);
	  Factory.getProjectDAO().deleteProject(project);
    //throw new RuntimeException("Test not implemented");
  }

  @Test
  public void deleteProject() throws SQLException {
	  Factory.getProjectDAO().addProject(project);
	  ArrayList<Project> expected = new ArrayList<Project>();
	  expected.addAll(Factory.getProjectDAO().getAllProjects());
	  expected.remove(expected.lastIndexOf(project));
	  Factory.getProjectDAO().deleteProject(project);
	  ArrayList<Project> actual = new ArrayList<Project>();
	  actual.addAll(Factory.getProjectDAO().getAllProjects());
	  Factory.getProjectDAO().deleteProject(null);
	  assertEquals(actual, expected);	  
    //throw new RuntimeException("Test not implemented");
  }

  @Test
  public void getAllProjects() throws SQLException {
	  int expected = Factory.getProjectDAO().getCount();
	  ArrayList<Project> actualList= (ArrayList<Project>) Factory.getProjectDAO().getAllProjects();
	  int actual = actualList.size();
	  assertEquals(actual, expected);
    //throw new RuntimeException("Test not implemented");
  }

  @Test
  public void getProjectById() throws SQLException {
	  Project expected = Factory.getProjectDAO().getProjectById(1);
	  Project actual = new Project();
	  actual.setProjectId(1);
	  actual.setProjectName("Hibernate Query Language");
	  Factory.getProjectDAO().getProjectById(0);
	  assertEquals(actual, expected);
    //throw new RuntimeException("Test not implemented");
  }

  @Test
  public void getProjectsByStudent() {
    //throw new RuntimeException("Test not implemented");
  }

  @Test
  public void updateProject() throws SQLException {
	  Project expected = project;
	  expected.setProjectId(10);
	  expected.setProjectName(".NET");
	  Factory.getProjectDAO().addProject(expected);
	  expected.setProjectName("Java");
	  Factory.getProjectDAO().updateProject(10, expected);
	  Project actual = Factory.getProjectDAO().getProjectById(10);
	  assertEquals(actual, expected);
	  Factory.getProjectDAO().updateProject(155, new Project());
	  Factory.getProjectDAO().deleteProject(expected);
    //throw new RuntimeException("Test not implemented");
  }
}
