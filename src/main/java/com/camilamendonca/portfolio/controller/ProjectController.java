package com.camilamendonca.portfolio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.camilamendonca.portfolio.entity.ListType;
import com.camilamendonca.portfolio.service.ProjectService;

@Controller
public class ProjectController {
	
	@Autowired
	ProjectService projectService;	
	
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("projects", projectService.listProjects(ListType.MAIN));
		return "index";
	}	
	
	

}
