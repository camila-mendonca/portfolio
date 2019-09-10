package com.camilamendonca.portfolio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.camilamendonca.portfolio.entity.ProjectPicture;
import com.camilamendonca.portfolio.repository.ProjectPictureRepository;

@Service
public class ProjectPictureServiceImpl implements ProjectPictureService {

	@Autowired
	ProjectPictureRepository pictureRepository;
	
	@Override
	public void save(ProjectPicture picture) {
		pictureRepository.save(picture);
	}

	@Override
	public void updatePicture(ProjectPicture picture) {
		// TODO Auto-generated method stub

	}

	@Override
	public Iterable<ProjectPicture> listPicturesByProject(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProjectPicture loadPicture(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deletePicture(ProjectPicture picture) {
		// TODO Auto-generated method stub

	}

}
