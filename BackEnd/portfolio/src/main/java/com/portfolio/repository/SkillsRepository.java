package com.portfolio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.portfolio.vo.Skills;

@Repository
public interface SkillsRepository extends JpaRepository<Skills,Integer>{
	
	List<Skills> findByIsActive(Character isActive);
}
