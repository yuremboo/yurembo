package com.java.deany;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import com.java.deany.StudentsField;
import com.java.utils.WorkWithRegex;
import com.java.utils.WorkWithXML;

public class StudentsList<E> extends ArrayList<E> implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5653602324956363704L;
	
	/**
	 * @param s - student
	 * @return true - if student was transported to the next course, false - if not.
	 */
	public boolean increaseCourse(Student s){
		int oneCourse = 100;
		int maxCourse = 500; //max course * 100
		if (s.getGroup() < maxCourse) {
			s.setGroup(s.getGroup()+oneCourse);
			return true;
		}
		return false;
	}
	
	/**
	 * @param fileName - name of text-file with students in selected format
	 */
    @SuppressWarnings("unchecked")
	public void loadFromFile(String fileName){
		List<Student> stud = new ArrayList<>();
        Scanner in = null;
		try  {
			in = new Scanner(new File(fileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
        while(in.hasNext())
        {
        	String line = in.nextLine();
            if (WorkWithRegex.checkLine(line, Student.regExp))
            {
            	String[] str = line.split(" ");
                stud.add(new Student(str[1], str[2], Double.parseDouble(str[3]), Integer.parseInt(str[4])));
            }
        }
        in.close();    
		this.addAll(((Collection<? extends E>) stud));
	}
    
	/**
	 * Save students list from file
	 * @param filename - name of text-file to save students list in selected format
	 */
	public void saveToFile(String filename){
		FileWriter fileWriter = null;
		try {
			fileWriter = new FileWriter(filename);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		String newLine = System.getProperty("line.separator");
		String students = "";
		for (E s:this) {
				students += s.toString() + newLine;
			}
		try {
			fileWriter.write(students);
			fileWriter.close();
	    } catch (IOException e) {
	    	e.printStackTrace();
	    }
	}
        
    /**
     * Sort students list by field
	 * @param field - parameter of StudentsField type
	 */
	@SuppressWarnings("unchecked")
	public void orderBy(StudentsField field){
		Collections.sort((List<Student>)this, new Order(field));
	}
	
	/**
	 * Get students by GROUP,MARK,COURSE
	 * overloaded method getStudentsBy
	 * 
	 * @param field - StudentsField
	 * @param operator - Character
	 * @param i - Double
	 * @return StudentsList<E>
	 */
	public StudentsList<E> getStudentsBy(StudentsField field, Character operator, Double i)
	{
		StudentsList<E> resultStudentsList = new StudentsList<>();
		for (E s:this){
			if (field == StudentsField.MARK)
				switch (operator) {
				case '=':{
					if (i == ((Student) s).getAverageMark()) resultStudentsList.add(s);
					break;
				}
				case '>':{
					if (i < ((Student) s).getAverageMark()) resultStudentsList.add(s);
					break;
				}
				case '<':{
					if (i > ((Student) s).getAverageMark()) resultStudentsList.add(s);
					break;
				}
				default:break;
			}
			else return null;
		}
		return resultStudentsList;
	}
	
	
	/**
	 * Get students by GROUP,MARK,COURSE
	 * overloaded method getStudentsBy
	 * 
	 * @param field - StudentsField
	 * @param operator - Character
	 * @param i - int
	 * @return StudentsList<E>
	 */
	public StudentsList<E> getStudentsBy(StudentsField field, Character operator, int i)
	{
		StudentsList<E> resultStudentsList = new StudentsList<>();
		for (E s:this){
			if (field == StudentsField.GROUP || field == StudentsField.COURSE)
				switch (operator) {
				case '=':{
					if (field == StudentsField.GROUP && i == ((Student) s).getGroup()) resultStudentsList.add(s);
					if (field == StudentsField.COURSE && i == (int)(((Student) s).getGroup()/100)) resultStudentsList.add(s);
					break;
				}
				case '>':{
					if (field == StudentsField.GROUP && i < ((Student) s).getGroup()) resultStudentsList.add(s);
					if (field == StudentsField.COURSE && i < (int)(((Student) s).getGroup()/100)) resultStudentsList.add(s);
					break;
				}
				case '<':{
					if (field == StudentsField.GROUP && i > ((Student) s).getGroup()) resultStudentsList.add(s);
					if (field == StudentsField.COURSE && i < (int)(((Student) s).getGroup()/100)) resultStudentsList.add(s);
					break;
				}
				default:break;
			}
			else return null;
		}
		return resultStudentsList;
	}
	
    /**
     * 
     * Serialize students list to file
     * @param fileName - Name of existing file on HDD.
     */ 
	public void serializeStudentsList(String fileName)
	{
		try{
			FileOutputStream fos = new FileOutputStream(fileName);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(this);
			oos.flush();
			oos.close();
			System.out.println("Serialization DONE");
		}
		catch (IOException e) {
				// TODO: handle exception
			e.printStackTrace();
		}
	}
        
    
	/**
     * Deserialize students list from file
     * @param fileName - Name of serialized file before.
     */
	@SuppressWarnings("unchecked")
	public void deserializeStudentsList(String fileName)
	{
		this.clear();
		StudentsList<E> ts = null;
		try{
			FileInputStream fis = new FileInputStream(fileName);
			ObjectInputStream oin = new ObjectInputStream(fis);
			ts = ((StudentsList<E>) oin.readObject());
			oin.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		this.addAll(ts);
		//return ts;
	}
        
    /**
     * Save students list to XML file
     * @param xmlFileName - Name of XML-file to save students list.
     */
	@SuppressWarnings("unchecked")
	public void saveToXml(String xmlFileName)
	{
		try {
			WorkWithXML.saveToXml((StudentsList<Student>) this, xmlFileName);	
		} 
		catch (ParserConfigurationException | TransformerException e) {
			e.printStackTrace();
		}
		
	}
    
	/**
     * Save students list to XML file
     * @param xmlFileName - Name of XML-file to load students list from.
     */
    @SuppressWarnings("unchecked")
	public void loadFromXml(String xmlFileName)
	{
		this.addAll((Collection<? extends E>) WorkWithXML.loadFromXML(xmlFileName));
	}
    
   

}
