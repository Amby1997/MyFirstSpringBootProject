package com.aws.aws.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.aws.aws.entities.User;
import com.aws.aws.exception.ResourseNotFoundException;
import com.aws.aws.repository.UserRepository;

@RestController
public class UserController {
	@Autowired
	private UserRepository userRepository;
	// get all users
	@GetMapping("/users")
	public List<User> getAllUserDetails(){
		return userRepository.findAll();
	}
	
	// get user by id
	@GetMapping("/users/{userId}")
	public User getSingleUserDetails(@PathVariable Long userId){
		return userRepository.findById(userId).orElseThrow(()-> new ResourseNotFoundException("User not found with id: "+userId));
	}
	// create user
	@PostMapping("/users")
	public User createUserDetails(@RequestBody User user){
		 userRepository.save(user);
		 return userRepository.save(user);
		 
	}
	
	// update user
	@PutMapping("/users/{userId}")
	public User updateUserDetails(@RequestBody User user,@PathVariable Long userId){
		User existing = userRepository.findById(userId).orElseThrow(()-> new ResourseNotFoundException("User not found with id: "+userId));
		 existing.setEmail(user.getEmail());
		 existing.setFname(user.getFname());
		 existing.setLname(user.getLname());
		 userRepository.save(existing);
		 return user; 
	}
	// delete user by id
	@DeleteMapping("/users/{userId}")
	public void deleteUserDetails(@PathVariable Long userId){
		User user = userRepository.findById(userId).orElseThrow(()-> new ResourseNotFoundException("User not found with id: "+userId));
		userRepository.delete(user);
		
	}
}
