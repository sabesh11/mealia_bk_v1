package com.example.mealia.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.mealia.model.Emplyoee;

import com.example.mealia.repo.EmplyoeeRepo;

@RestController
@RequestMapping("/Emplyooe")
public class EmplyooeController {
	
	@Autowired
	private EmplyoeeRepo emplyoeeRepo;
	
	@PostMapping("/addEmplyoee")
	public ResponseEntity<?> addEmplyoee(@RequestBody Emplyoee emplyoee ){
		 
		Emplyoee emplyoee1 = emplyoeeRepo.save(emplyoee);  
		
			 return ResponseEntity.status(HttpStatus.OK)
			        .body(emplyoee1);
		 }
	
	@GetMapping("/getEmplyoeebyId/{emplyoeeId}")
	public ResponseEntity<?> getEmplyoeebyId(@PathVariable Long emplyoeeId ){
		 
		Optional<Emplyoee> emplyoee2 = emplyoeeRepo.findById(emplyoeeId);  
		
			 return ResponseEntity.status(HttpStatus.OK)
			        .body(emplyoee2);
		 }
	
	@PostMapping("/updateEmplyooeeSalary/{emplyoeeId}/{salary}")
	public ResponseEntity<?> updateEmplyooeeSalary(@PathVariable Long emplyoeeId,@PathVariable String salary ){

		Emplyoee emplyoee2 = emplyoeeRepo.findById(emplyoeeId).get();
		
		
		emplyoee2.setSalary(salary);
		emplyoee2.setName(emplyoee2.getName());
		emplyoee2.setPosition(emplyoee2.getPosition());
		emplyoeeRepo.save(emplyoee2);
		
		return ResponseEntity.status(HttpStatus.OK)
				.body("emplyoee updated");
		
}
	
	@GetMapping("/getEmplyoeeList")
		public ResponseEntity<?> getEmplyooeeSalary(){
			List<Emplyoee> emplyoee = emplyoeeRepo.findAll();
			return ResponseEntity.status(HttpStatus.OK)
					.body(emplyoee);
		}
	
	@GetMapping("/getEmplyoeeBySalary")
	 public ResponseEntity<?> getEmplyoeebyhighSalary(){
		List<Emplyoee> emplyoeebySalary = emplyoeeRepo.getEmplyoeebySalary();
		return ResponseEntity.status(HttpStatus.OK).
				body(emplyoeebySalary);
	}
	}

