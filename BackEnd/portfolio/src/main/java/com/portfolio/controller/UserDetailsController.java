package com.portfolio.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.portfolio.dto.UserDetailsDTO;
import com.portfolio.service.UserDetailsService;
import com.portfolio.vo.Skills;
import com.portfolio.vo.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/users")
public class UserDetailsController {

    @Autowired
    private UserDetailsService userService;

    @GetMapping
    public List<UserDetailsDTO> getAllUserDetails() {
        return userService.getAllUserDetails();
    }

    @PostMapping
	public ResponseEntity<Skills> createUser(@RequestBody UserDetails user){
    	userService.createUser(user);
	    return new ResponseEntity<>(HttpStatus.CREATED);
	}

    @GetMapping("{userId}")
    public ResponseEntity<UserDetails> getUserById(@PathVariable("userId") Integer userId) {
        return ResponseEntity.ok(userService.getUserById(userId));
    }

    @PutMapping(consumes = {"multipart/form-data"})
    public ResponseEntity<UserDetails> updateUser(@RequestPart("user") UserDetails user, @RequestPart(value = "resume", required = false) MultipartFile resumeFile) {
        
        return new ResponseEntity<>(userService.updateUser(user, resumeFile), HttpStatus.OK);
    }

    @DeleteMapping("{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable("userId") Integer userId) {
        userService.deleteUser(userId);
        return ResponseEntity.ok("User marked as inactive.");
    }
}