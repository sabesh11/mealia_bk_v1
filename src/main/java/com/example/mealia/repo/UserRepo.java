package com.example.mealia.repo;


import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.example.mealia.model.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

	@Query(value="Select * from users WHERE name= :name AND PASSWORD = :password", nativeQuery= true)
    User findByUser(String name, String password);

	@Query(value="SELECT * FROM Users  WHERE username = :username",nativeQuery= true)
    User findByUsername(String username);
	
	 
	 
	        
	
	@Query(value="SELECT * FROM Users  WHERE id = :id",nativeQuery= true)
	 User findFirstById(Long id);
	
	
	
}
