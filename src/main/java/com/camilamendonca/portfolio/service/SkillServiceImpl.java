package com.camilamendonca.portfolio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.camilamendonca.portfolio.entity.Skill;
import com.camilamendonca.portfolio.repository.SkillRepository;

@Service
public class SkillServiceImpl implements SkillService {
	
	@Autowired
	SkillRepository skillRepository;

	@Override
	public Iterable<Skill> listSkills() {
		Iterable<Skill> skills = skillRepository.findAll();
		return skills;
	}

}
