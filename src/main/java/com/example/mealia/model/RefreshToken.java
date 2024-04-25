//package com.example.mealia.model;
//
//
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import java.time.Instant;
//
//
//@Entity
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@Builder
//@Table(name = "REFRESH_TOKENS")
//public class RefreshToken {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int id;
//    private String token;
//
//    private Instant expiryDate;
//    
//
//    @OneToOne
//    @JoinColumn(name = "user_id")
//    private User user;
//
//	public int getId() {
//		return id;
//	}
//
//	public void setId(int id) {
//		this.id = id;
//	}
//
//	public User getUser() {
//		return user;
//	}
//
//	public void setUser(User user) {
//		this.user = user;
//	}
//
//	public String getToken() {
//		return token;
//	}
//
//	public void setToken(String token) {
//		this.token = token;
//	}
//
//	public Instant getExpiryDate() {
//		return expiryDate;
//	}
//
//	public void setExpiryDate(Instant expiryDate) {
//		this.expiryDate = expiryDate;
//	}
//
//	public static Object builder() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//	
//}