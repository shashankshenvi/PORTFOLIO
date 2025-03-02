package com.portfolio.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portfolio.exception.ResourceNotFoundException;
import com.portfolio.repository.SkillsRepository;
import com.portfolio.vo.Skills;

@Service
public class SkillsServiceImpl implements SkillsService{

	
	private static final Logger logger =LoggerFactory.getLogger(SkillsServiceImpl.class);
	
	@Autowired
	private SkillsRepository skillsRepository;
	
	@Override
	public List<Skills> getAllSkills() {
		return skillsRepository.findByIsActive('Y');
	}

	@Override
	public Skills createSkill(Skills skill) {
		return skillsRepository.save(skill);
	}

	@Override
	public Skills getSkillById(Integer skillId) {
		Skills skill = skillsRepository.findById(skillId).orElseThrow(() -> new ResourceNotFoundException("Skill not found"));
		return skill;
	}

	@Override
	public Skills updateSkill(Skills skill) {
		Skills updatedSkill = skillsRepository.save(skill);
		return updatedSkill;
	}

	@Override
	public void deleteSkill(Skills skill) {
		skillsRepository.findById(skill.getSkillId()).ifPresent(skillNew->{
			skillNew.setIsActive('N');
			skillsRepository.save(skillNew);
		});		
	}

}
