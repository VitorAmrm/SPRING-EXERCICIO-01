package com.ayty.fintech.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Seller{
	
	@Column
	private String social_name;
	
	@Column
	private String fantasy_name;
	
	@Column(unique=true)
	private Long cnpj;
	
	
	@Column(unique = true)
	private String username;
	
	@Id
	@Column(unique=true)
	private Long owner_id;
	
	public String getSocial_name() {
		return social_name;
	}
	public void setSocial_name(String social_name) {
		this.social_name = social_name;
	}
	public String getFantasy_name() {
		return fantasy_name;
	}
	public void setFantasy_name(String fantasy_name) {
		this.fantasy_name = fantasy_name;
	}
	public Long getCnpj() {
		return cnpj;
	}
	public void setCnpj(Long cnpj) {
		this.cnpj = cnpj;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Long getOwner_id() {
		return owner_id;
	}
	public void setOwner_id(Long owner_id) {
		this.owner_id = owner_id;
	}
	
	
	
}
