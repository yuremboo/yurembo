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

import com.java.deany.entity.Group;
import com.java.deany.service.DepartmentServiceImpl;
import com.java.deany.service.GroupServiceImpl;

@Controller
public class GroupController {
	
	private GroupServiceImpl groupDAO = new GroupServiceImpl();
	private DepartmentServiceImpl departmentDAO = new DepartmentServiceImpl();
	static Logger log = LogManager.getLogger(GroupController.class);
	@RequestMapping(value = "/groups.html" , method = RequestMethod.GET)
	public ModelAndView listGroups(@RequestParam(value = "departmentId", required = false) Integer id) {
		if (id == null) return new ModelAndView("WEB-INF/jsp/groups.jsp", "groups", groupDAO.getAllGroups());
		return new ModelAndView("WEB-INF/jsp/groups.jsp", "groups", groupDAO.getGroupsByDepartment(departmentDAO.getDepartmentById(id)));
		
	}
	
	@RequestMapping(value = "/addGroup.html", method = RequestMethod.GET)
	public String showCreateGroup(Model model) {
		Group group = new Group();
		model.addAttribute("group", group);
		model.addAttribute("department", departmentDAO.getAllDepartments());
		return "WEB-INF/jsp/addEditGroup.jsp";
	}
	
	@RequestMapping(value = "/addGroup.html", method = RequestMethod.POST)
	public String addGroup(@ModelAttribute("group") Group group, BindingResult result) {
		log.info(group);
		groupDAO.addGroup(group);
		return "redirect:/groups.html";
	}
	
	@RequestMapping(value = "/editGroup.html", method = RequestMethod.GET)
	public String showEditGroup(@RequestParam("groupNumber") Integer groupNumber, Model model) {
		model.addAttribute("group", groupDAO.getGroupByNumber(groupNumber));
		model.addAttribute("department", departmentDAO.getAllDepartments());
		return "WEB-INF/jsp/addEditGroup.jsp";
		
	}
	
	@RequestMapping(value = "/editGroup.html", method = RequestMethod.POST)
	public String editGroup(@ModelAttribute("group") Group group, BindingResult result) {
		groupDAO.updateGroup(group.getGroupNumber(), group);
		log.info(group);
		return "redirect:/groups.html";
	}
	
	@RequestMapping(value = "/deleteGroup.html", method = RequestMethod.GET)
	public String showDelGroup(@RequestParam("groupNumber") Integer groupNumber, Model model) {
		model.addAttribute("group", groupDAO.getGroupByNumber(groupNumber));
		return "WEB-INF/jsp/deleteGroup.jsp";
		
	}
	
	@RequestMapping(value = "/deleteGroup.html", method = RequestMethod.POST)
	public String deleteGroup(@ModelAttribute("group") Group group, BindingResult result) {
		groupDAO.deleteGroup(group);
		log.info(group);
		return "redirect:/groups.html";
	}


}
