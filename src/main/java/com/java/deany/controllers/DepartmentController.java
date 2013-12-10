package com.java.deany.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.java.deany.service.DepartmentServiceImpl;

@Controller
public class DepartmentController {
	
	private DepartmentServiceImpl departmentDAO = new DepartmentServiceImpl();
	
	@RequestMapping("/departments")
	public ModelAndView listDepartments() {
		return new ModelAndView("WEB-INF/jsp/departments.jsp", "departments", departmentDAO.getAllDepartments());
		
	}

}
