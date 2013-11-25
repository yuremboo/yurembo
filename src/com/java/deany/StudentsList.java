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

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.java.deany.StudentsField;
import com.java.utils.Util;

public class StudentsList<E> extends ArrayList<E> implements Serializable{

	/**
	 * 
	 */

	private static final long serialVersionUID = 5653602324956363704L;
	
	public boolean increaseCourse(Student s){
		if ( s.getGroup() < 500) {
			s.setGroup(s.getGroup()+100);
			System.out.println("Student has been transferred to the next course!");
			return true;
		}
		System.out.println("This student is on the last course!");
		return false;
	}
	
        /*
         * Load students list from file
         */
        
	@SuppressWarnings("unchecked")
	public boolean loadFromFile(String fileName){
		List<Student> stud = new ArrayList<>();
        Scanner in = null;
		try  {
			in = new Scanner(new File(fileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
                        return false;
		}
            while(in.hasNext())
            {
                    String line = in.nextLine();
                    if (Util.checkLine(line, Student.regExp))
                    {
                            String[] str = line.split(" ");
                            stud.add(new Student(str[1], str[2], Double.parseDouble(str[3]), Integer.parseInt(str[4])));
                    }
            }
//******************
		this.addAll(((Collection<? extends E>) stud));
                return true;
	}
	
        /*
         * Save students list from file
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
		for (E s:this){
			students += s.toString() + newLine;
		}
		
		try {
			fileWriter.write(students);
			fileWriter.close();
	    } catch (IOException e) {
	    	e.printStackTrace();
	    }
	}
        
        /*
         * Sort students list by field
         */
	
	@SuppressWarnings("unchecked")
	public void sortBy(StudentsField field){
//**********************
		System.out.println("-----Sorted by " + field + "------");
		Collections.sort((List)this, new Sort(field));
	}
	
	/*
	 * Get students by GROUP,MARK,COURSE
	 * overloaded method getStudentsBy
	 */
		
	public StudentsList<E> getStudentsBy(StudentsField field, Character operator, Double i)
	{
		System.out.println("-----Students where " + field + "" + operator + "" + i +"------");
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
	
	public StudentsList<E> getStudentsBy(StudentsField field, Character operator, int i)
	{
		System.out.println("-----Students where " + field + "" + operator + "" + i +"------");
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
	
        /*
         * Serialize students list to file
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
		finally {
			System.out.println("***");
		}
	}
        
        /*
         * Deserialize students list from file
         */
	
	public StudentsList<E> deserializeStudentsList(String fileName)
	{
		StudentsList<E> ts = null;
		try{
			FileInputStream fis = new FileInputStream(fileName);
			ObjectInputStream oin = new ObjectInputStream(fis);
			ts = ((StudentsList<E>) oin.readObject());
			oin.close();
			System.out.println("Deserialization DONE");
			//System.out.println("version="+ts.serialVersionUID);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		finally {
			
		}
		
		return ts;
	}
        
        /*
         * Save students list to XML file
         */
	
	@SuppressWarnings("unchecked")
	public void saveToXml(String xmlFileName)
	{
		List<Student> stud = (List<Student>) this;
		try
		{
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			//root elements
			Document doc = docBuilder.newDocument();
			Element rootElement = doc.createElement("deany");
			doc.appendChild(rootElement);
			//staff elements
			
			//int i = 0;
			
			for (Student s:stud){
				//i++;
				Element studs = doc.createElement("Students");
				rootElement.appendChild(studs);

				  //set attribute to staff element
				  Attr attr = doc.createAttribute("id");
				  attr.setValue(String.valueOf(s.getId()));
				  studs.setAttributeNode(attr);
		
				  //shorten way
				  //staff.setAttribute("id", "1");

				  //firstname elements
				  Element firstname = doc.createElement("firstname");
				  firstname.appendChild(doc.createTextNode(s.getFirstName()));
				  studs.appendChild(firstname);
		
				  //lastname elements
				  Element lastname = doc.createElement("lastname");
				  lastname.appendChild(doc.createTextNode(s.getLastName()));
				  studs.appendChild(lastname);
		
				  //averageMark elements
				  Element averageMark = doc.createElement("averageMark");
				  averageMark.appendChild(doc.createTextNode(String.valueOf(s.getAverageMark())));
				  studs.appendChild(averageMark);
		
				  //group elements
				  Element group = doc.createElement("group");
				  group.appendChild(doc.createTextNode(String.valueOf(s.getGroup())));
				  studs.appendChild(group);
		
				  
			}
			//write the content into xml file
			  TransformerFactory transformerFactory = TransformerFactory.newInstance();
			  Transformer transformer = transformerFactory.newTransformer();
			  DOMSource source = new DOMSource(doc);
	
			  StreamResult result =  new StreamResult(new File(xmlFileName));
			  transformer.transform(source, result);
	
			  System.out.println("Done");

		}catch(ParserConfigurationException pce){
		  pce.printStackTrace();
		}catch(TransformerException tfe){
		  tfe.printStackTrace();
		}
	}
        
    public boolean loadFromXml(String xmlFileName)
	{
    	StudentsList<Student> students = new StudentsList<>();
    	Document doc = null;
    	//get the factory
    	DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder docBuilder = dbf.newDocumentBuilder();
			doc = docBuilder.parse(new File(xmlFileName));
		} 
		catch(ParserConfigurationException pce) {
			pce.printStackTrace();
		}catch(SAXException se) {
			se.printStackTrace();
		}catch(IOException ioe) {
			ioe.printStackTrace();
		}
		
		//get the root element
		Element docEle = doc.getDocumentElement();

		//get a nodelist of  elements
		NodeList nl = docEle.getElementsByTagName("Students");
		
		if(nl != null && nl.getLength() > 0) {
			for(int i = 0 ; i < nl.getLength();i++) {
				
				//get the student element
				Element el = (Element)nl.item(i);
				//get the Student object
				Student st = getStudent(el);
				//add it to list
				if (Util.checkLine(st.toString(),Student.regExp)) students.add(st);
			}
		}
		this.addAll((Collection<? extends E>) students);
		return true;
	}
    
   
    /**
	 * I take a Students element and read the values in, create
	 * an Students object and return it
	 */
	private static Student getStudent(Element studEl) {

		//for each <Student> element get text or int values of
		//firstname, lastname, id, averageMark and group
		String firstName = getTextValue(studEl,"firstname");
		String secondName = getTextValue(studEl,"lastname");
		double averageMark = getDoubleValue(studEl,"averageMark");
		int group = getIntValue(studEl,"group");

		String type = studEl.getAttribute("id");

		//Create a new Student with the value read from the xml nodes
		Student e = new Student(secondName,firstName,averageMark,group);

		return e;
	}


	private static double getDoubleValue(Element studEl, String tagName) {
		// TODO Auto-generated method stub
		return Double.parseDouble(getTextValue(studEl,tagName));
	}

	/**
	 * I take a xml element and the tag name, look for the tag and get
	 * the text content
	 */
	private static String getTextValue(Element ele, String tagName) {
		
		String textVal = null;
		NodeList nl = ele.getElementsByTagName(tagName);
		if(nl != null && nl.getLength() > 0) {
			Element el = (Element)nl.item(0);
			textVal = el.getFirstChild().getNodeValue();
		}

		return textVal;
	}


	/**
	 * Calls getTextValue and returns a int value
	 */
	private static int getIntValue(Element ele, String tagName) {
		try {
			return Integer.parseInt(getTextValue(ele,tagName));
		}catch(NumberFormatException nfe){
			nfe.printStackTrace();
			return 0;
		}
	}
}
