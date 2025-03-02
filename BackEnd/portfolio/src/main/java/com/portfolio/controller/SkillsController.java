package com.portfolio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.portfolio.service.SkillsService;
import com.portfolio.vo.Skills;

@CrossOrigin(origins = "http://localhost:5173") 
@RestController
@RequestMapping("/api/skills")
public class SkillsController {
	
	@Autowired
	private SkillsService skillsService;
	
	@GetMapping
	public List<Skills> getAllSkills(){
		return skillsService.getAllSkills();
	}

	@PostMapping
	public ResponseEntity<Skills> createSkill(@RequestBody Skills skill){
	    return new ResponseEntity<>(skillsService.createSkill(skill), HttpStatus.CREATED);
	}

	@GetMapping("{skillId}")
	public ResponseEntity<Skills> getSkillById(@PathVariable("skillId") Integer skillId){
		return ResponseEntity.ok(skillsService.getSkillById(skillId));
	}

	@PutMapping
	public ResponseEntity<Skills> updateSkill(@RequestBody Skills skill){
		return new ResponseEntity<>(skillsService.updateSkill(skill),HttpStatus.CREATED);
	}

	@DeleteMapping
	public void deleteSkill(@RequestBody Skills skill){
		skillsService.deleteSkill(skill);
	}


}
