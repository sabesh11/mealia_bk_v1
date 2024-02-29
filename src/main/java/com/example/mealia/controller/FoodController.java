package com.example.mealia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.mealia.repo.FoodRepo;

import com.example.mealia.model.FoodDetail;

@RestController
@RequestMapping("/food")
public class FoodController {

	@Autowired
	private FoodRepo foodrepo;
	@PostMapping("/addfood")
	public ResponseEntity<?> setFood(@RequestBody FoodDetail fooddetail ){
		 
		FoodDetail food = foodrepo.save(fooddetail);
		
			 return ResponseEntity.status(HttpStatus.OK)
			        .body(food);
		 }
	@GetMapping("/getfood")
	public ResponseEntity<?> getFood(){
		List<FoodDetail> food1 =foodrepo.findAll();
		
		return ResponseEntity.status(HttpStatus.OK)
		        .body(food1);
		 }
	
}
