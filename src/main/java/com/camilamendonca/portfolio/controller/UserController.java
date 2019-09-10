package com.camilamendonca.portfolio.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import com.camilamendonca.portfolio.entity.ListType;
import com.camilamendonca.portfolio.entity.Project;
import com.camilamendonca.portfolio.entity.ProjectPicture;
import com.camilamendonca.portfolio.service.ProjectPictureService;
import com.camilamendonca.portfolio.service.ProjectService;
import com.camilamendonca.portfolio.service.SkillService;
import com.camilamendonca.portfolio.util.FileSaver;

@Controller
public class UserController {
	
	@Autowired
	ProjectService projectService;
	
	@Autowired
	SkillService skillService;
	
	@Autowired
	ProjectPictureService pictureService;
	
	@Autowired
	FileSaver fileSaver;
	
	@GetMapping("/user")
	public String userIndex(Model model) {
		model.addAttribute("projects", projectService.listProjects(ListType.ALL));
		return "user/list-projects";
	}
	
	@GetMapping("/user/newproject")
	public String projectForm(Project project, Model model) {
		model.addAttribute("skills", skillService.listSkills());		
		return "user/add-project";
	}
	
	@PostMapping("/user/addproject")
	public String addProject(Project project) {
		projectService.saveProject(project);
		return "redirect:/user";
	}
	
	@GetMapping("/user/project/{id}")
	public String loadProject(@PathVariable("id") Long projectId, Model model, ProjectPicture picture) {
		Project project = projectService.loadProject(projectId);
		model.addAttribute("project", project);
		picture.setProject(project);
		model.addAttribute("picture", picture);
		return "/user/project";
	}
	
	@PostMapping("/user/addpicture")
	public String addPicture(@Valid ProjectPicture picture, MultipartFile file, BindingResult bindingResult) {
		String projectId = Long.toString(picture.getProject().getId());
		String r = "redirect:/user/project/" + projectId;
		if(bindingResult.hasErrors()) {
			return r;
		}
		String path = fileSaver.write("projectpictures", file);
		picture.setPath(path);
		pictureService.save(picture);
		return r;
	}

}
