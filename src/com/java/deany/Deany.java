package com.java.deany;

public class Deany {

	StudentsList<Student> students = new StudentsList<>();
        public final String serializedFile = "students.out";
        public final String textFile = "students.txt";
        public final String xmlFile = "students.xml";
        //public static String regExp = "(([\\d]*)[\\s][A-Z]{1}[a-z-]*[\\s][A-Z]{1}[a-z-]*[\\s][1-5]\\.[\\d][\\s][1-5][\\d]{2})";
        
        	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Deany();
	}
	
	public Deany() {
		//if (!students.loadFromFile(textFile)) 
		students.deserializeStudentsList(serializedFile);  //Serialization  
		//students.loadFromXml(xmlFile);
		//students.add(new Student("Alexandrov","Alex",4.3,541)); //add new student
		for (Student s:students){
			System.out.println(s); //print all students
			if (s.getLastName().compareTo("Ivanov") == 0) {
				students.increaseCourse(s);
				System.out.println(s);
				}
			}
		students.orderBy(StudentsField.MARK);  //sorting students list
		for (Student s:students){
			System.out.println(s); //print all students
		}
		
		/*
		 * overloaded method StudentsList<E> getStudentsBy(StudentsField field, Character operator, Double i)
		 * 					 StudentsList<E> getStudentsBy(StudentsField field, Character operator, int i)
		 */
		
		StudentsList<Student> studentsBy = new StudentsList<>();
		studentsBy.addAll(students.getStudentsBy(StudentsField.MARK,'>',4.0));
		
		for (Student s:studentsBy){
			System.out.println(s); //print all studentsBy
		}
		
		//students.saveToFile(textFile);  //Save to file
		students.serializeStudentsList(serializedFile);  //Serialization
		//students.saveToXml(xmlFile);
                
	}
}
