package com.portfolio.service;

import com.portfolio.dto.ContactDTO;
import com.portfolio.dto.UserDetailsDTO;
import com.portfolio.exception.ResourceNotFoundException;
import com.portfolio.repository.UserDetailsRepository;
import com.portfolio.vo.UserDetails;
import com.portfolio.vo.UserInstance;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
    private static final Logger logger = LoggerFactory.getLogger(UserDetailsServiceImpl.class);

    @Autowired
    private UserDetailsRepository userDetailsRepository;

    @Autowired
    private GoogleDriveService googleDriveService;

    @Override
    public List<UserDetailsDTO> getAllUserDetails() {
        List<UserDetails> userDetailsList = userDetailsRepository.findByIsActive('Y');

        List<UserDetailsDTO> response = new ArrayList<>();

        for (UserDetails user : userDetailsList) {
            // Create a new DTO to hold the final data structure
            UserDetailsDTO userDetailsDTO = new UserDetailsDTO();
            userDetailsDTO.setUserId(user.getUserId());
            userDetailsDTO.setFirstName(user.getFirstName());
            userDetailsDTO.setLastName(user.getLastName());
            userDetailsDTO.setIsActive(user.getIsActive());
            List<ContactDTO> contacts = new ArrayList<>();

            // Fetch the contacts associated with the user
            if (user.getContacts() != null) {
                for (UserInstance contact : user.getContacts()) {
                    ContactDTO contactDTO = new ContactDTO();
                    contactDTO.setType(contact.getType());
                    contactDTO.setValue(contact.getValue());
                    contactDTO.setImageSrc(contact.getImageSrc());
                    contacts.add(contactDTO);
                }
            }

            // Set the contacts for the current user
            userDetailsDTO.setContacts(contacts);

            // Add the current user's details to the response list
            response.add(userDetailsDTO);
        }

        return response;
    }

    @Override
    public UserDetails createUser(UserDetails user) {
        user.setIsActive('Y');
        if (user.getContacts() != null) {
            for (UserInstance contact : user.getContacts()) {
                contact.setUser(user);  
            }
        }
        return userDetailsRepository.save(user);
    }
    @Override
    public UserDetails getUserById(Integer userId) {
        return userDetailsRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
    }

    @Override
    public UserDetails updateUser(UserDetails user, MultipartFile resumeFile) {
        if (resumeFile != null && !resumeFile.isEmpty()) {
            try {
                String fileId = googleDriveService.uploadFile(resumeFile);
            } catch (Exception e) {
                throw new RuntimeException("Failed to upload resume", e);
            }
        }
        return userDetailsRepository.save(user);
    }

    @Override
    public void deleteUser(Integer userId) {
        userDetailsRepository.findById(userId).ifPresent(existingUser -> {
            existingUser.setIsActive('N');
            userDetailsRepository.save(existingUser);
        });
    }
}