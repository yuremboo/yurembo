package com.java.deany;

import java.util.Comparator;

import com.java.deany.StudentsField;

public class Order implements Comparator<Student> {
	private StudentsField field;
	/**
	 * 
	 * @param field - field of the table fo students. Type: StudentsField.
	 */
	public Order(StudentsField field) {
		this.field = field;
	}

	@Override
	public int compare(Student arg0, Student arg1) {
		// TODO Auto-generated method stub
		final int magicNumber = 1000;
		if (field == StudentsField.ID) 
			return arg0.getId() - arg1.getId();
		if (field == StudentsField.LASTNAME) 
			return arg0.getLastName().compareTo(arg1.getLastName());
		if (field == StudentsField.FIRSTNAME) 
			return arg0.getFirstName().compareTo(arg1.getFirstName());
		if (field == StudentsField.MARK)
			return (int)(arg0.getAverageMark() * magicNumber - arg1.getAverageMark() * magicNumber); 
		if (field == StudentsField.GROUP) 
			return arg0.getGroup() - arg1.getGroup();
		return 0;		
	}
}
