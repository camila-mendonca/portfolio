package com.camilamendonca.portfolio.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.camilamendonca.portfolio.entity.Skill;

@Repository
public interface SkillRepository extends CrudRepository<Skill, String>{

}
