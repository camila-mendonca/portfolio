package com.camilamendonca.portfolio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.camilamendonca.portfolio.entity.Project;
import com.camilamendonca.portfolio.entity.ProjectPicture;
import com.camilamendonca.portfolio.repository.ProjectPictureRepository;

@Service
public class ProjectPictureServiceImpl implements ProjectPictureService {

	@Autowired
	ProjectPictureRepository pictureRepository;
	
	@Override
	public void save(ProjectPicture picture) {
		// If the new picture was set as a thumbnail we need to make sure that the project doesn't have a thumbnail already
		if(picture.getThumbnail()) {
			Project project = picture.getProject();
			for (ProjectPicture pic : project.getPictures()) {
				// If so, we set the old thumbnail as false
				if (pic.getThumbnail()) pic.setThumbnail(false);
			}
		}
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
		pictureRepository.delete(picture);
	}

}
