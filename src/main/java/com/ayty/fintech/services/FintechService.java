package com.ayty.fintech.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ayty.fintech.entity.Consumer;
import com.ayty.fintech.entity.Seller;
import com.ayty.fintech.entity.User;
import com.ayty.fintech.exceptions.AlreadyExistException;
import com.ayty.fintech.exceptions.NotFoundException;
import com.ayty.fintech.repository.ConsumerRepository;
import com.ayty.fintech.repository.SellerRepository;
import com.ayty.fintech.repository.UserRepository;

@Service
public class FintechService {
	
	@Autowired
	UserRepository repo;
	
	@Autowired
	ConsumerRepository conRepo;
	
	@Autowired
	SellerRepository sellRepo;
	
	
	
	public User saveUser(User newUser) throws AlreadyExistException  {
		if(repo.findByemail(newUser.getEmail())!= null) {
			throw new AlreadyExistException("Usuario já existe");
			
		}else {
			return repo.save(newUser);
		}
	}
	
	public List<User> findAllUsers(){
		return repo.findAll();
	}
	
	public User findUserById(Long id) throws NotFoundException{
		
		User user = new User(); 

		if(!repo.findById(id).isPresent()) {
			throw new NotFoundException("Usuario não existe");
		}
		else {
			 user = repo.findById(id).get();
			 
			 return user;
		}
		
	}
	
	public User updateUser (Long id, User newUser) throws NotFoundException  {
		if(!repo.findById(id).isPresent()) {
			throw new NotFoundException("Usuario não existe");
		}
		else {
			User updatedUser = repo.findById(id).get();
			updatedUser.setFullname(newUser.getFullname());
			updatedUser.setCpf(newUser.getCpf());
			updatedUser.setEmail(newUser.getEmail());
			updatedUser.setSenha(newUser.getSenha());
			updatedUser.setTelefone(newUser.getTelefone());
			return repo.save(updatedUser);
		}
	}
	
	public void deleteUser (Long id) throws NotFoundException{
		if(!repo.findById(id).isPresent()) {
			throw new NotFoundException("Usuario não existe");
		}else {
			repo.deleteById(id);
		}
	}
	
	public Consumer saveConsumer (Consumer newConsumer) throws AlreadyExistException {
		if(conRepo.findById(newConsumer.getUser_id()).isPresent()) {
			throw new AlreadyExistException("Conta Consumidor deste usuario já existe");
		}
		else if(conRepo.findByUsername(newConsumer.getUsername()) != null) {
			throw new AlreadyExistException("Conta com esse nome já existe");
		}
		else {
			return conRepo.save(newConsumer);
		}
	}
	
	public Seller saveSeller (Seller newSeller) throws AlreadyExistException{
		if(sellRepo.findById(newSeller.getOwner_id()).isPresent()) {
			throw new AlreadyExistException("Conta lojista deste usuario já existe");
		}else if(sellRepo.findByUsername(newSeller.getUsername())!= null) {
			throw new AlreadyExistException("Conta com esse nome já existe");
		}else {
			return sellRepo.save(newSeller);
		}
	}
}
