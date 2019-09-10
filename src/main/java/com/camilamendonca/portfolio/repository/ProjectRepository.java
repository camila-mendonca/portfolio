package com.camilamendonca.portfolio.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.camilamendonca.portfolio.entity.Project;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Long>{
	
	Iterable<Project> findAllByMainTrue();

}
