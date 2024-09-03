package com.example.mealia.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.example.mealia.model.Emplyoee;

import jakarta.transaction.Transactional;

public interface EmplyoeeRepo extends JpaRepository<Emplyoee, Long> {
	
   @Modifying
   @Transactional
   @Query(value="SELECT * FROM Emplyoees  ORDER BY salary DESC", nativeQuery = true)
   List<Emplyoee> getEmplyoeebySalary();
}
