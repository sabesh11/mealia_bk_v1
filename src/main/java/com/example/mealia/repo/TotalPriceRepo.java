package com.example.mealia.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.mealia.model.TotalPrice;

public interface TotalPriceRepo extends JpaRepository<TotalPrice, Integer> {

}
