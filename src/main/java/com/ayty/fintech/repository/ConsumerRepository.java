package com.ayty.fintech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ayty.fintech.entity.Consumer;

@Repository
public interface ConsumerRepository extends JpaRepository<Consumer,Long>{
	public Consumer findByUsername(String username);
}
