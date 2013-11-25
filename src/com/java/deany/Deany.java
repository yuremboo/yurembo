package com.java.deany;

public class Deany {

	StudentsList<Student> students = new StudentsList<>();
        public final String serializedFile = "students.out";
        public final String textFile = "students.txt";
        public final String xmlFile = "students.xml";
   
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Deany();
	}
	
	public Deany() {
		students.equals(students);

		// TODO Auto-generated constructor stub
		if (!students.loadFromFile(textFile)) 
		//	students.deserializeStudentsList(serializedFile);  //Serialization  
		students.loadFromXml(xmlFile);
		//students.add(new Student("Alexandrov","Alex",4.3,541)); //add new student
		for (Student s:students){
			System.out.println(s); //print all students
			if (s.getLastName().compareTo("Ivanov") == 0) {
				students.increaseCourse(s);
				System.out.println(s);
			} 		}
                
             
		
                
		/*
		 * public void sortBy(StudentsField field)
		 */
		students.sortBy(StudentsField.MARK);  //sorting students list
		
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
