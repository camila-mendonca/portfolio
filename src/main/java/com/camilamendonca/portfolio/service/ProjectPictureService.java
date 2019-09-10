package com.camilamendonca.portfolio.service;

import com.camilamendonca.portfolio.entity.ProjectPicture;

public interface ProjectPictureService {
	
	public void save(ProjectPicture picture);
	public void updatePicture(ProjectPicture picture);
	public Iterable<ProjectPicture> listPicturesByProject(Long id);
	public ProjectPicture loadPicture(Long id);
	public void deletePicture(ProjectPicture picture);

}
