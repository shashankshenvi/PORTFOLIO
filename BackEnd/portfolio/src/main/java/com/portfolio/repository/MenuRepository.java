package com.portfolio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.portfolio.vo.Menu;

@Repository
public interface MenuRepository extends JpaRepository<Menu,Integer>{
	
	List<Menu> findByIsActive(Character isActive);
}
