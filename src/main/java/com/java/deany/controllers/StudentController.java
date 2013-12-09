package com.java.deany.controllers;

import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.java.deany.service.StudentServiceImpl;

@Controller
public class StudentController {
	
	private StudentServiceImpl studentDAO = new StudentServiceImpl();
	
	@RequestMapping("/students.html")
	public ModelAndView listStudents() throws SQLException {
		return new ModelAndView("WEB-INF/jsp/students.jsp", "students", studentDAO.getAllStudents());
		
	}

}
