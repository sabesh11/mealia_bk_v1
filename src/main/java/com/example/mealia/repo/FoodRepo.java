package com.example.mealia.repo;

import java.util.List;
import com.example.mealia.model.FoodDetail;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;



public interface FoodRepo extends JpaRepository<FoodDetail, Integer> {

	@Query(value="Select * from fooddetail", nativeQuery= true)
	List<FoodDetail> findAll();

	

}
