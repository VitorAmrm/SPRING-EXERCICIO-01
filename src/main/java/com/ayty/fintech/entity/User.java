package com.ayty.fintech.entity;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long id;
	
	@Column
	private String fullname;
	
	@Column(unique=true)
	private Long cpf;
	
	@Column
	private Long telefone;
	
	@Column(unique=true)
	private String email;
	
	@Column
	private String senha;
	
	@OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private  Consumer conAccount;
	
	//@OneToOne(cascade = CascadeType.ALL)
	//@JoinColumn(name= "owner_id",insertable=false, updatable=false)
	//private Seller sellAccount;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public Long getCpf() {
		return cpf;
	}

	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}

	public Long getTelefone() {
		return telefone;
	}

	public void setTelefone(Long telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Consumer getConAccount() {
		return conAccount;
	}

	public void setConAccount(Consumer conAccount) {
		this.conAccount = conAccount;
	}
/*
	public Seller getSellAccount() {
		return sellAccount;
	}

	public void setSellAccount(Seller sellAccount) {
		this.sellAccount = sellAccount;
	}
*/
	@Override
	public String toString() {
		return   "{id :"+ id +","
				+" fullname:" + fullname+", cpf:" + cpf + ", telefone:" + telefone + ", email:"
				+ email + ", senha:" + senha + ",Account : [ conAccount:"+ conAccount + ","
														+ "sellAccount=" +  "]";
	}
	
	
	
	

	
	

	
	
	
	
	
	
	
	
	
}
