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
import com.java.deany.entity.Group;

public class GroupDAOImplTest extends Assert {
  Group group = new Group();
		
  @BeforeClass
  public void beforeClass() {
	  group.setGroupNumber(599);
	  group.setDepartmentId(1);
	  group.setCurator("Test Curator");
  }


  @AfterClass
  public void afterClass() {
  }

  @BeforeTest
  public void beforeTest() {
	  
  }

  @AfterTest
  public void afterTest() {
	  
  }


  @Test
  public void addGroup() throws SQLException {
	  
	  
	  ArrayList<Group> expected = new ArrayList<Group>();
	  expected.addAll(Factory.getGroupDAO().getAllGroups());
	  expected.add(group);
	  
	  Factory.getGroupDAO().addGroup(group);
	  ArrayList<Group> actual = new ArrayList<Group>();
	  actual.addAll(Factory.getGroupDAO().getAllGroups());
	  assertEquals(actual, expected);

	  Factory.getGroupDAO().deleteGroup(group);
    //throw new RuntimeException("Test not implemented");
  }

  @Test
  public void deleteGroup() throws SQLException {
	  Factory.getGroupDAO().addGroup(group);
	  ArrayList<Group> expected = new ArrayList<Group>();
	  expected.addAll(Factory.getGroupDAO().getAllGroups());
	  expected.remove(expected.lastIndexOf(group));
	  Factory.getGroupDAO().deleteGroup(group);
	  ArrayList<Group> actual = new ArrayList<Group>();
	  actual.addAll(Factory.getGroupDAO().getAllGroups());
	  Factory.getGroupDAO().deleteGroup(null);
	  assertEquals(actual, expected);	
	  Factory.getGroupDAO().deleteGroup(group);
    //throw new RuntimeException("Test not implemented");
  }

  @Test
  public void getGroupByNumber() throws SQLException {
	  Factory.getGroupDAO().addGroup(group);
	  Group expected = Factory.getGroupDAO().getGroupByNumber(599);
	  Group actual = group;
	  Factory.getGroupDAO().getGroupByNumber(0);
	  assertEquals(actual, expected);
	  Factory.getGroupDAO().deleteGroup(group);
    //throw new RuntimeException("Test not implemented");
  }

  @Test
  public void getGroupsByDepartment() {
    //throw new RuntimeException("Test not implemented");
  }

  @Test
  public void updateGroup() throws SQLException {
	 /* Factory.getGroupDAO().addGroup(group);
	  Group expected = group;
	  expected.setCurator("Newcurator");
	  Factory.getGroupDAO().updateGroup(599, expected);
	  Group actual = Factory.getGroupDAO().getGroupByNumber(599);
	  assertEquals(actual, expected);
	  Factory.getGroupDAO().updateGroup(999, new Group());
	  Factory.getGroupDAO().deleteGroup(expected);
	  Factory.getGroupDAO().deleteGroup(group);*/
    //throw new RuntimeException("Test not implemented");
  }
}
