  package com.example.mealia.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="carts")
public class Cart {
	 @Id
	    @GeneratedValue
		private int id;
		private String  food;
		private int  price;
		private int  total;
		private int quantity;
		private String img;
		
		@ManyToMany(cascade = CascadeType.ALL)
		private List<User> user;
		
		
		public List<User> getUser() {
			return user;
		}
		public void setUser(List<User> user) {
			this.user = user;
		}
		public String getImg() {
			return img;
		}
		public void setImg(String img) {
			this.img = img;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getFood() {
			return food;
		}
		public void setFood(String food) {
			this.food = food;
		}
		public int getPrice() {
			return price;
		}
		public void setPrice(int price) {
			this.price = price;
		}
		public int getTotal() {
			return total;
		}
		public void setTotal(int total) {
			this.total = total;
		}
		public int getQuantity() {
			return quantity;
		}
		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}
		
}
