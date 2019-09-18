package com.camilamendonca.portfolio.controller;

import java.util.ArrayList;
import java.util.List;

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
import com.camilamendonca.portfolio.entity.SelectedSkills;
import com.camilamendonca.portfolio.entity.Skill;
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
	
	private static Iterable<SelectedSkills> loadSelectedSkills(Iterable<Skill> skills, Iterable<Skill> projectSkills){
		List<SelectedSkills> selSkills = new ArrayList<SelectedSkills>();
		for(Skill s : skills) {
			if(isSelected(s.getName(), projectSkills)) {				
				selSkills.add(new SelectedSkills(s.getName(),true));				
			} else {
				selSkills.add(new SelectedSkills(s.getName(), false));
			}
		}
		return selSkills;
	}
	
	private static boolean isSelected(String skill, Iterable<Skill> projectSkills) {
		boolean r = false;
		for(Skill ps : projectSkills) {
			if(skill==ps.getName());
			r = true;
		}
		return r;
	}
	
	@GetMapping("/user/project/{id}")
	public String loadProject(@PathVariable("id") Long projectId, Model model, ProjectPicture picture) {
		Project project = projectService.loadProject(projectId);
		model.addAttribute("project", project);
		picture.setProject(project);
		model.addAttribute("picture", picture);
		model.addAttribute("selectskills", loadSelectedSkills(skillService.listSkills(), project.getSkills()));
		return "user/project";
	}
	
	@PostMapping("/user/editproject")
	public String editProject(Model model, Project project, ProjectPicture picture) {
		//Figure out why it's duplicating the project when I deselect a skill and fix
		//Update: That's because I'm not sending the id...
		projectService.saveProject(project);
		model.addAttribute("project", project);
		picture.setProject(project);
		model.addAttribute("picture", picture);
		model.addAttribute("selectskills", loadSelectedSkills(skillService.listSkills(), project.getSkills()));
		return "user/project";
	}
	
	@PostMapping("/user/addpicture")
	public String addPicture(@Valid ProjectPicture picture, MultipartFile file, BindingResult bindingResult) {
		String projectId = Long.toString(picture.getProject().getId());
		String redirect = "redirect:/user/project/" + projectId;
		if(bindingResult.hasErrors()) {
			return redirect;
		}
		String path = fileSaver.write("projectpictures", file);
		picture.setPath(path);
		pictureService.save(picture);
		return redirect;
	}

}
