package com.portfolio.repository;

import com.portfolio.vo.UserInstance;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface UserInstanceRepository extends JpaRepository<UserInstance, Integer> {
    
    // Corrected method name
    List<UserInstance> findByUser_UserId(Integer userId);  // This works because of the correct mapping in UserDetails
}