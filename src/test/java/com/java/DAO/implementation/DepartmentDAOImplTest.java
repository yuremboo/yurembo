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
import com.java.deany.entity.Department;
import com.java.deany.entity.Student;

public class DepartmentDAOImplTest extends Assert{
	Department department = new Department();
  @BeforeClass
  public void beforeClass() {
	  department.setDepartmentName("Test department");
	  department.setDepartmentId(3);
  }

  @AfterClass
  public void afterClass() {
	  //department = null;
  }

  @BeforeTest
  public void beforeTest() {
  }

  @AfterTest
  public void afterTest() {
  }


  @Test
  public void addDepartment() throws SQLException {
	  ArrayList<Department> expected = new ArrayList<Department>();
	  expected.addAll(Factory.getDepartmentDAO().getAllDepartments());
	  expected.add(department);
	  Factory.getDepartmentDAO().addDepartment(department);
	  ArrayList<Department> actual = new ArrayList<Department>();
	  actual.addAll(Factory.getDepartmentDAO().getAllDepartments());
	  Factory.getDepartmentDAO().addDepartment(null);
	  assertEquals(actual, expected);
    //throw new RuntimeException("Test not implemented");
  }

  @Test
  public void deleteDepartment() throws SQLException {
	  ArrayList<Department> expected = new ArrayList<Department>();
	  expected.addAll(Factory.getDepartmentDAO().getAllDepartments());
	  expected.remove(expected.lastIndexOf(department));
	  Factory.getDepartmentDAO().deleteDepartment(department);
	  ArrayList<Department> actual = new ArrayList<Department>();
	  actual.addAll(Factory.getDepartmentDAO().getAllDepartments());
	  Factory.getDepartmentDAO().deleteDepartment(null);
	  assertEquals(actual, expected);
    //throw new RuntimeException("Test not implemented");
  }

  @Test
  public void getAllDepartments() throws SQLException {
	  int expected = Factory.getDepartmentDAO().getCount();
	  ArrayList<Department> actualList= (ArrayList<Department>) Factory.getDepartmentDAO().getAllDepartments();
	  int actual = actualList.size();
	  assertEquals(actual, expected);
    //throw new RuntimeException("Test not implemented");
  }

  @Test
  public void getDepartmentById() throws SQLException {
	  Department expected = Factory.getDepartmentDAO().getDepartmentById(1);
	  Department actual = new Department();
	  actual.setDepartmentId(1);
	  actual.setDepartmentName("CSN");
	  Factory.getDepartmentDAO().getDepartmentById(0);
	  assertEquals(actual, expected);
    //throw new RuntimeException("Test not implemented");
  }

  @Test
  public void updateDepartment() throws SQLException {
	  Department expected = new Department();
	  expected.setDepartmentId(5);
	  expected.setDepartmentName("NET");
	  Factory.getDepartmentDAO().addDepartment(expected);
	  expected.setDepartmentName("J");
	  Factory.getDepartmentDAO().updateDepartment(5, expected);
	  Department actual = Factory.getDepartmentDAO().getDepartmentById(5);
	  assertEquals(actual, expected);
	  Factory.getDepartmentDAO().deleteDepartment(actual);
    //throw new RuntimeException("Test not implemented");
  }
}
