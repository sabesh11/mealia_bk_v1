package com.example.mealia.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import lombok.ToString;


@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String Name;
	private String Email;
	private String Password;
	private String ConfirmPassword;

	
	
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Cart> cart;
//	 @ManyToMany(fetch = FetchType.EAGER)
//	    private Set<UserRole> roles = new HashSet<>();
//
//	
//	
//	
//	public Set<UserRole> getRoles() {
//		return roles;
//	}
//	public void setRoles(Set<UserRole> roles) {
//		this.roles = roles;
//	}
	public List<Cart> getCart() {
		return cart;
	}
	public void setCart(List<Cart> cart) {
		this.cart = cart;
	}
	public User(int id, String name, String email, String password, String confirmPassword) {
		super();
		this.id = id;
		this.Name = name;
		this.Email = email;
		this.Password = password;
		this.ConfirmPassword = confirmPassword;
		
	}
	public User() {
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	
	public String getConfirmPassword() {
		return ConfirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		ConfirmPassword = confirmPassword;
	}
	
	
	
	
}
