package com.example.mealia.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import com.example.mealia.repo.CartRepo;
import com.example.mealia.repo.UserRepo;
//import com.example.mealia.service.JwtService;
import com.example.mealia.model.Cart;
import com.example.mealia.model.User;


@RestController
@RequestMapping("/User")
public class UserController{

	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private CartRepo cartRepo;
	
//	 @Autowired
//	    private JwtService jwtService;

//	    @Autowired
//	    RefreshTokenService refreshTokenService;


//	    @Autowired
//	    private  AuthenticationManager authenticationManager;
	
	User user = new User();
	
	@PostMapping("/signup")
	public ResponseEntity<?> setUser(@RequestBody User user ){
		 
	User user1 = userRepo.save(user);
		
		 return ResponseEntity.status(HttpStatus.OK)
		        .body(user1);
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
	
	@PostMapping("/addcart/{userid}")
	public ResponseEntity<?> addCart(@RequestBody Cart cart,@PathVariable int userid ){
		
		
		 
	User user = userRepo.findById(userid).get();
	
	user.getCart().add(cart);
	
    userRepo.save(user);           		
		 return ResponseEntity.status(HttpStatus.OK)
		        .body(cart);
	 }
	
//	 @PreAuthorize("hasAuthority('ROLE_ADMIN')")
//	    @GetMapping("/test")
//	    public String test() {
//	        try {
//	            return "Welcome";
//	        } catch (Exception e){
//	            throw new RuntimeException(e);
//	        }
//	    }
	
//	 @PostMapping("/login")
//	    public JwtResponseDTO AuthenticateAndGetToken(@RequestBody AuthRequestDTO authRequestDTO){
//	        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequestDTO.getUsername(), authRequestDTO.getPassword()));
//	        if(authentication.isAuthenticated()){
//	            RefreshToken refreshToken = refreshTokenService.createRefreshToken(authRequestDTO.getUsername());
//	           return JwtResponseDTO.builder()
//	                   .accessToken(jwtService.GenerateToken(authRequestDTO.getUsername())
//	                   .token(refreshToken.getToken()).build();
//                   } 
//	        else {
//	            throw new UsernameNotFoundException("invalid user request..!!");
//	        }
//
//	    }
//
//
//	 @PostMapping("/refreshToken")
//	    public JwtResponseDTO refreshToken(@RequestBody RefreshTokenRequestDTO refreshTokenRequestDTO){
//	        return refreshTokenService.findByToken(refreshTokenRequestDTO.getToken())
//	                .map(refreshTokenService::verifyExpiration)
//	                .map(RefreshToken::getuser)
//	                .map(user -> {
//	                    String accessToken = jwtService.GenerateToken(user.getName());
//	                    return JwtResponseDTO.builder()
//	                            .accessToken(accessToken)
//	                            .token(refreshTokenRequestDTO.getToken()).build();
//	                }).orElseThrow(() ->new RuntimeException("Refresh Token is not in DB..!!"));
//	    }
}
