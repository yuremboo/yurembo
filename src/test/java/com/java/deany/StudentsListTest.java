package com.java.deany;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

import com.java.deany.entity.Student;
import com.java.deany.StudentsField;

public class StudentsListTest extends Assert{
  @Test(dataProvider = "dp")
  public void f(Integer n, String s) {
  }

  @DataProvider
  public Object[][] dp() {
    return new Object[][] {
      new Object[] { 1, "a" },
      new Object[] { 2, "b" },
    };
  }
  
  StudentsList<Student> students = new StudentsList<Student>();
  Student firstStudentTest = new Student("Test", "First", (float) 4.5, 521);
  Student secondStudentTest = new Student("Test", "Second", (float) 5.0, 321);
  Student thirdStudentTest = new Student("Testt", "Third", (float) 3.0, 441);
  
  @BeforeClass
  public void beforeClass() {
	  firstStudentTest = new Student("Test", "First", (float) 4.5, 521);
	  secondStudentTest = new Student("Test", "Second", (float) 5.0, 321);
	  thirdStudentTest = new Student("Testt", "Third", (float) 3.0, 441);
  }

  @AfterClass
  public void afterClass() {
	  students.clear();
  }
  
  @BeforeTest
  public void beforeTest() {
	  students.add(firstStudentTest);
	  students.add(secondStudentTest);
	  students.add(thirdStudentTest);
  }
  
  @AfterTest
  public void afterTest(){
	  students.clear();
  }


  @Test
  public void deserializeStudentsList() {
	  StudentsList<Student> expectedList = new StudentsList<Student>();	  
	  expectedList.add(firstStudentTest);
	  expectedList.add(secondStudentTest);
	  expectedList.add(thirdStudentTest);
	  expectedList.serializeStudentsList("studentsText.out");
	  StudentsList<Student> actualList = new StudentsList<Student>();
	  actualList.deserializeStudentsList("studentsText.out");
	  assertEquals(actualList, expectedList);
  }

  @Test
  public void getStudentsByMark() {
	  ArrayList<Student> expected = new ArrayList<Student>();
	  expected.add(secondStudentTest);
	  ArrayList<Student> actual = new ArrayList<Student>();
	  actual = students.getStudentsBy(StudentsField.MARK, '>', 4.6);
	  assertEquals(actual, expected);
  }

  @Test
  public void getStudentsByCourse() {
	  ArrayList<Student> expected = new ArrayList<Student>();
	  expected.add(firstStudentTest);
	  ArrayList<Student> actual = new ArrayList<Student>();
	  actual = students.getStudentsBy(StudentsField.COURSE, '>', 4);
	  assertEquals(actual, expected);
  }
  
  @Test
  public void getStudentsByGroup() {
	  ArrayList<Student> expected = new ArrayList<Student>();
	  expected.add(secondStudentTest);
	  ArrayList<Student> actual = new ArrayList<Student>();
	  actual = students.getStudentsBy(StudentsField.GROUP, '<', 421);
	  assertEquals(actual, expected);
  }
  
  @Test
  public void getStudentsByGroupEqual() {
	  ArrayList<Student> expected = new ArrayList<Student>();
	  expected.add(secondStudentTest);
	  ArrayList<Student> actual = new ArrayList<Student>();
	  actual = students.getStudentsBy(StudentsField.GROUP, '=', 321);
	  assertEquals(actual, expected);
  }
  
  @Test
  public void getStudentsByGroupNull() {
	  ArrayList<Student> expected = new ArrayList<Student>();
	  expected = null;
	  ArrayList<Student> actual = new ArrayList<Student>();
	  actual = students.getStudentsBy(StudentsField.FIRSTNAME, '*', 322);
	  assertEquals(actual, expected);
  }

  @Test
  public void increaseCourseV1() {
	  students.increaseCourse(firstStudentTest);
	  int expected = 521;
	  int actual = firstStudentTest.getGroupNumber();
	  assertEquals(actual, expected);
  }
  
  @Test
  public void increaseCourseV2() {
	  students.increaseCourse(secondStudentTest);
	  int expected = 421;
	  int actual = secondStudentTest.getGroupNumber();
	  assertEquals(actual, expected);
  }

  @Test//(expectedExceptions = FileNotFoundException.class)
  public void workWithFile() {
	  StudentsList<Student> expectedList = new StudentsList<Student>();	  
	  expectedList.add(firstStudentTest);
	  expectedList.add(secondStudentTest);
	  expectedList.add(thirdStudentTest);
	  expectedList.saveToFile("studentsTest.txt");
	  StudentsList<Student> actualList = new StudentsList<Student>();
	  actualList.loadFromFile("studentsTest.txt");
	  assertEquals(actualList, expectedList);
  }

  @Test
  public void loadFromXml() {
	  StudentsList<Student> expectedList = new StudentsList<Student>();	  
	  expectedList.add(firstStudentTest);
	  expectedList.add(secondStudentTest);
	  expectedList.add(thirdStudentTest);
	  expectedList.saveToXml("studentsText.xml");
	  StudentsList<Student> actualList = new StudentsList<Student>();
	  actualList.loadFromXml("studentsText.xml");
	  assertEquals(actualList, expectedList);
  }

  @Test
  public void orderByGroupTrue() {
	  StudentsList<Student> expected = new StudentsList<Student>();
	  expected.add(secondStudentTest);
	  expected.add(thirdStudentTest);
	  expected.add(firstStudentTest);
	  StudentsList<Student> actual = new StudentsList<Student>();
	  actual.add(secondStudentTest);
	  actual.add(firstStudentTest);
	  actual.add(thirdStudentTest);
	  actual.orderBy(StudentsField.GROUP);
	  assertEquals(actual, expected);
  }
  
  @Test
  public void orderByFirstNameTrue() {
	  StudentsList<Student> expected = new StudentsList<Student>();
	  expected.add(firstStudentTest);
	  expected.add(secondStudentTest);
	  expected.add(thirdStudentTest);
	  StudentsList<Student> actual = new StudentsList<Student>();
	  actual.add(secondStudentTest);
	  actual.add(firstStudentTest);
	  actual.add(thirdStudentTest);
	  

	  actual.orderBy(StudentsField.FIRSTNAME);

	  assertEquals(actual, expected);
  }
  
  @Test
  public void orderByMarkFalse() {
	  StudentsList<Student> expected = new StudentsList<Student>();
	  expected.add(secondStudentTest);
	  expected.add(firstStudentTest);
	  expected.add(thirdStudentTest);
	  StudentsList<Student> actual = new StudentsList<Student>();
	  actual.add(firstStudentTest);
	  actual.add(secondStudentTest);
	  actual.add(thirdStudentTest);
	  actual.orderBy(StudentsField.MARK);
	  assertNotEquals(actual, expected);
  }
}
