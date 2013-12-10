package com.java.deany.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.java.deany.service.ProjectServiceImpl;

@Controller
public class ProjectController {
	
	private ProjectServiceImpl ProjectDAO = new ProjectServiceImpl();
	
	@RequestMapping("/projects")
	public ModelAndView listProjects() {
		return new ModelAndView("WEB-INF/jsp/projects.jsp", "projects", ProjectDAO.getAllProjects());
		
	}

}
