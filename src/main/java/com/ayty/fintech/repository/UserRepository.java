package com.ayty.fintech.repository;




import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ayty.fintech.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long>{
	
	public User findByemail(String email) ;
	
	public User findByid(Long id);
	
}
