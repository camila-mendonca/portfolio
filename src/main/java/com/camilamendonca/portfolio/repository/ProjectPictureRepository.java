package com.camilamendonca.portfolio.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.camilamendonca.portfolio.entity.ProjectPicture;

@Repository
public interface ProjectPictureRepository extends CrudRepository<ProjectPicture, Long> {

}
