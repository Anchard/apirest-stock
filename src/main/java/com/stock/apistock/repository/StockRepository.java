package com.stock.apistock.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stock.apistock.models.Stock;

public interface StockRepository extends JpaRepository<Stock, Long> {
	
	Stock findByName(String name);

}
