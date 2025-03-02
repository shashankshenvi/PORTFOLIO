package com.portfolio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.portfolio.vo.UserDetails;


@Repository
public interface UserDetailsRepository extends JpaRepository<UserDetails,Integer>{
	
	List<UserDetails> findByIsActive(Character isActive);
}
