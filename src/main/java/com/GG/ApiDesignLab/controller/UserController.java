package com.GG.ApiDesignLab.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.GG.ApiDesignLab.model.User;
import com.GG.ApiDesignLab.repository.UserRepository;

@RestController
public class UserController {
	
	@Autowired
	public UserRepository userRepository;
	
	
	//an endpoint to get all users
//	@GetMapping(value="/user")
//	public List<User> getUser(){
//		return (List<User>) userRepository.findAll();
//	}
	
	//New endpoint to get users and allows a query parametere for state 
	//otherwise to call original method
	@GetMapping("/users")
	public List<User> getUsers(@RequestParam(value="state", required=false) String state){
        if (state != null) {
            return (List<User>) userRepository.findAllByState(state);
        }
        return (List<User>) userRepository.findAll();
	}
	
	//create a new user in the database
	@PostMapping(value="/users")
	public void createUser(@RequestBody User user) {
		userRepository.save(user);
	}
	
	//update a specific users information /user/{there specific id}
	@PutMapping("/users/{id}")
	public void createUser(@PathVariable(value="id") Long id, @RequestBody User user){
	    userRepository.save(user);
	}
	
	//delete a specific user
	@DeleteMapping("/users/{id}")
	public void createUser(@PathVariable(value="id") Long id) {
		userRepository.deleteById(id);
	}
	
	//Add an endpoint to get a single user by id\
	//method has to return `Optional<User>`, meaning that the result might be null
	@GetMapping(value="/users/{id}")
	public Optional<User> getUserById(@PathVariable(value="id") long id) {
		return userRepository.findById(id);
	}
	
	
	
}
