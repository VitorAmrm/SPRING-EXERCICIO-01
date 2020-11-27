package com.ayty.fintech.repository;

import org.springframework.stereotype.Repository;

import com.ayty.fintech.entity.Seller;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface SellerRepository extends JpaRepository<Seller,Long>{
	public Seller findByUsername(String username);
	
}
