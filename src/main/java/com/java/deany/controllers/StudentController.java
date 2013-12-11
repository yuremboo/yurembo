package com.java.deany.controllers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.java.deany.entity.Student;
import com.java.deany.service.GroupServiceImpl;
import com.java.deany.service.StudentServiceImpl;

@Controller
public class StudentController {
	static Logger log = LogManager.getLogger(StudentController.class);
	private StudentServiceImpl studentDAO = new StudentServiceImpl();
	private GroupServiceImpl groupDAO = new GroupServiceImpl();
	
	@RequestMapping(value = "/students.html", method = RequestMethod.GET)
	public ModelAndView listStudents(@RequestParam(value = "groupNumber", required = false) Integer id) {
		if (id == null)	return new ModelAndView("WEB-INF/jsp/students.jsp", "students", studentDAO.getAllStudents());
		return new ModelAndView("WEB-INF/jsp/students.jsp", "students", studentDAO.getStudentsByGroup(id));
	}
	
	@RequestMapping(value = "/addStudent.html", method = RequestMethod.GET)
	public String showCreateStudent(Model model) {
		Student student = new Student();
		model.addAttribute("student", student);
		model.addAttribute("group", groupDAO.getAllGroups());
		return "WEB-INF/jsp/addEditStudent.jsp";
	}
	
	@RequestMapping(value = "/addStudent.html", method = RequestMethod.POST)
	public String addStudent(@ModelAttribute("student") Student student, BindingResult result) {
		studentDAO.addStudent(student);
		return "redirect:/students.html";
	}
	
	@RequestMapping(value = "/editStudent.html", method = RequestMethod.GET)
	public String showEditStudent(@RequestParam("id") Integer id, Model model) {
		model.addAttribute("student", studentDAO.getStudentById(id));
		model.addAttribute("group", groupDAO.getAllGroups());
		return "WEB-INF/jsp/addEditStudent.jsp";
		
	}
	
	@RequestMapping(value = "/editStudent.html", method = RequestMethod.POST)
	public String editStudent(@ModelAttribute("student") Student student, BindingResult result) {
		studentDAO.updateStudent(student.getId(), student);
		log.info(student);
		return "redirect:/students.html";
	}
	
	@RequestMapping(value = "/deleteStudent.html", method = RequestMethod.GET)
	public String showDelStudent(@RequestParam("id") Integer id, Model model) {
		model.addAttribute("student", studentDAO.getStudentById(id));
		return "WEB-INF/jsp/deleteStudent.jsp";
		
	}
	
	@RequestMapping(value = "/deleteStudent.html", method = RequestMethod.POST)
	public String deleteStudent(@ModelAttribute("student") Student student, BindingResult result) {
		studentDAO.deleteStudent(student);
		return "redirect:/students.html";
	}

}
