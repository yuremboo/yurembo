package com.java.utils;

import java.io.File;
import java.io.IOException;

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

import com.java.deany.Student;
import com.java.deany.StudentsList;

public class WorkWithXML {
	
	public static StudentsList<Student> loadFromXML(String xmlFileName){
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
				if (WorkWithRegex.checkLine(st.toString(),Student.regExp)) students.add(st);
			}
		}
		return students;
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
		//Create a new Student with the value read from the xml nodes
		Student e = new Student(secondName,firstName,averageMark,group);
		return e;
	}


	private static double getDoubleValue(Element studEl, String tagName) {
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
	
	public static void saveToXml(StudentsList<Student> students, String xmlFileName) throws ParserConfigurationException, TransformerException
	{
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
		//root elements
		Document doc = docBuilder.newDocument();
		Element rootElement = doc.createElement("deany");
		doc.appendChild(rootElement);
		//staff elements	
		for (Student s:students){
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
	}
}
