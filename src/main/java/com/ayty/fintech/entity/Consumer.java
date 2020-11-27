package com.ayty.fintech.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
public class Consumer{
	
	@Column(unique=true)
	private String username;
	
	@Id
	@Column
	private Long user_id;
	
	
	public Consumer() {
		
	}
	
	
	public Consumer(String username, Long user_id) {
		this.username = username;
		this.user_id = user_id;
	}


	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}
	
	
	
	
	
	
	
}
