package com.camilamendonca.portfolio.service;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.camilamendonca.portfolio.entity.ListType;
import com.camilamendonca.portfolio.entity.Project;
import com.camilamendonca.portfolio.entity.ProjectPicture;
import com.camilamendonca.portfolio.repository.ProjectRepository;

@Service
public class ProjectServiceImpl implements ProjectService{
	
	@Autowired
	ProjectRepository projectRepository;

	@Override
	public void saveProject(Project project) {
		projectRepository.save(project);		
	}

	@Override
	public void updateProject(Project project) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Iterable<Project> listProjects(ListType type) {
		Iterable<Project> projects = Collections.emptyList();				
		if (type == ListType.MAIN) {
			projects = projectRepository.findAllByMainTrue();
			//Iterable<ProjectPicture> pictures = Collections.emptyList();			
			for (Project p : projects) {
				Iterable<ProjectPicture> pictures = p.getPictures();
				//We set the first picture of the list as thumbnail, just in case none of them was marked as thumbnail
				p.setThumbnail(pictures.iterator().next().getPath());
				//Let's iterate through the project pictures to see if one of them was selected as thumbnail
				for (ProjectPicture pic : pictures) {
					//If so, this image will be set as thumbnail
					if (pic.getThumbnail()) p.setThumbnail(pic.getPath());
				}
			}
		} else {
			projects = projectRepository.findAll();
		}
		
		return projects;
	}

	@Override
	public Iterable<Project> listProjectsBySkill(String skill) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Project> listMainProjects() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Project loadProject(Long id) {
		Project project = projectRepository.findById(id).get();
		return project;
	}

}
