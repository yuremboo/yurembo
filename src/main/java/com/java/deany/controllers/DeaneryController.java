package com.java.deany.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * @author Yurik Mikhaletskiy
 * Controller for Spring
 *
 */
@Controller
public class DeaneryController {
	
	@RequestMapping("/index.html")
	public String index(Model model) {
		return "WEB-INF/jsp/index.jsp";
	}

}
