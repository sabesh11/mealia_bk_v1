package com.example.mealia.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.mealia.repo.CartRepo;
import com.example.mealia.repo.FoodRepo;
import com.example.mealia.repo.UserRepo;
import com.example.mealia.model.Cart;
import com.example.mealia.model.FoodDetail;
import com.example.mealia.model.TotalPrice;
import com.example.mealia.model.User;

@RestController
@RequestMapping("/food")
public class FoodController {

	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private FoodRepo foodrepo;
	
	@Autowired
	private CartRepo cartRepo;
	
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
	
	@GetMapping("/getcart/{userid}")
	
	public ResponseEntity<?> getcart(@PathVariable int userid){
		System.out.println("==============>"+userid);
		User user = userRepo.findById(userid).get();
		
		List<Cart> cart =user.getCart();
		
		return ResponseEntity.status(HttpStatus.OK)
		        .body(cart);
		 }
	
	@GetMapping("/deletecart/{userid}/{cartid}")
	public void deleteCart(@PathVariable int userid,@PathVariable int cartid){
		 cartRepo.deleteCart(userid, cartid);		
	}
	
//	@PostMapping("/updateTotal/{userid}")
//	public double updateTotal(@PathVariable int userid,@RequestBody TotalPrice price ) {
//		User user = userRepo.findById(userid).get();
//		user.setTotalPrices(price);
//		return ResponseEntity.status(HttpStatus.OK)
//		        .body();
//	}
	
	@GetMapping("/deletecart/{foodid}")
	public void deleteFood(@PathVariable int foodid){
		 FoodDetail deleteFood =foodrepo.findById(foodid).get();
		 foodrepo.delete(deleteFood);
		 
		 	
	}
	}

