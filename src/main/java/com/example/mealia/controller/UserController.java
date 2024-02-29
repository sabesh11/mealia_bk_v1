package com.example.mealia.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.mealia.repo.UserRepo;
import com.example.mealia.model.User;


@RestController
@RequestMapping("/User")
public class UserController{

	@Autowired
	private UserRepo userRepo;
	
	User user = new User();
	
	@PostMapping("/signup")
	public ResponseEntity<?> setUser(@RequestBody User user ){
		 
	User user1 = userRepo.save(user);
		
		 return ResponseEntity.status(HttpStatus.OK)
		        .body(user1.getName());
	 }
	
	@PostMapping("/signin")
	public ResponseEntity<?>  userVerify(@RequestBody User user ){
		 
		
		User user1 = userRepo.findByUser(user.getName(),user.getPassword());
		if(user1 != null) {
			return ResponseEntity.status(HttpStatus.OK)
			        .body(user1);
		}
		else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
	        .body("Data not found");
		}
		  		
		
		
		
		 
 
	 }
}
