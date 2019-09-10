package com.camilamendonca.portfolio.service;

import com.camilamendonca.portfolio.entity.ListType;
import com.camilamendonca.portfolio.entity.Project;

public interface ProjectService {
	
	public void saveProject(Project project);
	public void updateProject(Project project);
	public Iterable<Project> listProjects(ListType type);
	public Iterable<Project> listProjectsBySkill(String skill);
	public Iterable<Project> listMainProjects();
	public Project loadProject(Long id);

}
