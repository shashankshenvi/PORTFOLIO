package com.portfolio.service;

import java.util.List;

import com.portfolio.vo.Skills;


public interface SkillsService {
	
	List<Skills> getAllSkills();

	Skills createSkill(Skills skill);
	
	Skills getSkillById(Integer skillId);
	
	Skills updateSkill(Skills skill);
	
	void deleteSkill(Skills skill);
	



}
