package com.portfolio.service;

import com.portfolio.dto.UserDetailsDTO;
import com.portfolio.vo.UserDetails;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface UserDetailsService {
    List<UserDetailsDTO> getAllUserDetails();
    void createUser(UserDetails user);
    UserDetails getUserById(Integer userId);
    UserDetails updateUser(UserDetails user);
    void deleteUser(Integer userId);
}