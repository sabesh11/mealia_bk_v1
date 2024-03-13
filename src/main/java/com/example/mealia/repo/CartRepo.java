package com.example.mealia.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.example.mealia.model.Cart;

import jakarta.transaction.Transactional;

public interface CartRepo extends JpaRepository<Cart, Integer>{
    
	@Modifying
	@Transactional
	@Query(value="DELETE FROM users_cart WHERE user_id = ?1 AND cart_id =?2", nativeQuery= true)
	void deleteCart(int userId, int cartId);
}
