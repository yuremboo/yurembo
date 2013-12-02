package com.java.DAO.implementation;

import java.sql.SQLException;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

import com.java.deany.Factory;
import com.java.deany.StudentsField;
import com.java.deany.StudentsList;
import com.java.deany.entity.Group;
import com.java.deany.entity.Student;

public class StudentDAOImplTest extends Assert{
	Student student = new Student();
  @BeforeClass
  public void beforeClass() {
	  student.setFirstName("Firstnametest");
	  student.setLastName("Setlastnametest");
	  student.setGroupNumber(111);
	  student.setAverageMark(2);
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
  public void addStudent() throws SQLException {
	  StudentsList<Student> expected = Factory.getStudentDAO().getAllStudents();
	  expected.add(student);
	  Factory.getStudentDAO().addStudent(student);
	  StudentsList<Student> actual = Factory.getStudentDAO().getAllStudents();
	  
	  assertEquals(actual, expected);
    //throw new RuntimeException("Test not implemented");
  }

  @Test
  public void deleteStudent() throws SQLException {
	  StudentsList<Student> expected = Factory.getStudentDAO().getAllStudents();
	  expected.remove(expected.lastIndexOf(student));
	  Factory.getStudentDAO().deleteStudent(student);
	  StudentsList<Student> actual = Factory.getStudentDAO().getAllStudents();
	  
	  assertEquals(actual, expected);
    //throw new RuntimeException("Test not implemented");
  }

  @Test
  public void getAllStudents() {
    throw new RuntimeException("Test not implemented");
  }

  @Test
  public void getStudentById() throws SQLException {
	  Student expected = Factory.getStudentDAO().getStudentById(5);
	  Student actual = new Student("Ramsey", "Aaron", 4.0f, 241);
	  assertEquals(actual, expected);
//    throw new RuntimeException("Test not implemented");
  }

  @Test
  public void getStudentsByGroup() throws SQLException {
	  Group group = new Group();
	  group.setCurator("1");
	  group.setDepartmentId(1);
	  group.setGroupNumber(551);
	  
	  StudentsList<Student> expected = Factory.getStudentDAO().getAllStudents();
	  expected = expected.getStudentsBy(StudentsField.GROUP, '=', 551);
	  StudentsList<Student> actual = Factory.getStudentDAO().getStudentsByGroup(group);

	  assertEquals(actual, expected);
	  
    //throw new RuntimeException("Test not implemented");
  }

  @Test
  public void getStudentsByGroupint() throws SQLException {	  
	  StudentsList<Student> expected = Factory.getStudentDAO().getAllStudents();
	  expected = expected.getStudentsBy(StudentsField.GROUP, '=', 551);
	  StudentsList<Student> actual = Factory.getStudentDAO().getStudentsByGroup(551);

	  assertEquals(actual, expected);
    //throw new RuntimeException("Test not implemented");
  }

  @Test
  public void getStudentsByMark() throws SQLException {
	  StudentsList<Student> expected = Factory.getStudentDAO().getAllStudents();
	  expected = expected.getStudentsBy(StudentsField.MARK, '=', 5.0);
	  StudentsList<Student> actual = Factory.getStudentDAO().getStudentsByMark(5.0f);

	  assertEquals(actual, expected);
    //throw new RuntimeException("Test not implemented");
  }

  @Test
  public void getStudentsByProject() {
	  
    //throw new RuntimeException("Test not implemented");
  }

  @Test
  public void updateStudent() throws SQLException {
	  Student expected = new Student("Ramsey", "Aaron", 4.0f, 441);
	  Factory.getStudentDAO().updateStudent(5, student);
	  Student actual = Factory.getStudentDAO().getStudentById(5);
	  
	  assertEquals(actual, expected);
    //throw new RuntimeException("Test not implemented");
  }
}
