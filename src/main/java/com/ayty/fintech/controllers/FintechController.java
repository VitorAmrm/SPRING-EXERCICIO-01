package com.ayty.fintech.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ayty.fintech.entity.Consumer;
import com.ayty.fintech.entity.Seller;
import com.ayty.fintech.entity.User;
import com.ayty.fintech.exceptions.AlreadyExistException;
import com.ayty.fintech.exceptions.NotFoundException;
import com.ayty.fintech.services.FintechService;

@RestController
public class FintechController {
	
	@Autowired
	FintechService service;
	
	//Users 
	@GetMapping("/users")
	public List<User> findAll () {
		return service.findAllUsers();
	}
	
	@GetMapping("/users/{id}")
	public ResponseEntity<String> findUserByid(@PathVariable(name="id") Long id) {
		User user = new User();
		try {
			user = service.findUserById(id);
		} catch (NotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.OK).body(user.toString());
		
	}
	
	@PostMapping("/users")
	public ResponseEntity<String> postUser(@RequestBody User user) {
		User saved = new User();
		try {
			saved = service.saveUser(user);
		} catch (AlreadyExistException e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(saved.toString());
		
		
	}
	
	@PutMapping("users/{id}")
	public ResponseEntity<String> putUser(@PathVariable(name="id") Long id,@RequestBody User newUser){
		User update = new User();
		try {
			update = service.updateUser(id, newUser);
		} catch (NotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.OK).body(update.toString());
	}
	
	@DeleteMapping("users/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable(name="id") Long id){
		try {
			service.deleteUser(id);
		} catch (NotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.OK).body("Usuario deletado com sucesso");
	}
	//
	
	@PostMapping("users/consumers")
	public ResponseEntity<String> postConsumer(@RequestBody Consumer newConsumer){
			Consumer consum = new Consumer();
			try {
				consum = service.saveConsumer(newConsumer);
			} catch (AlreadyExistException e) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
			}
			return ResponseEntity.status(HttpStatus.CREATED).body(consum.toString());
	}
	@PostMapping("users/sellers")
	public ResponseEntity<String> postSeller (@RequestBody Seller newSeller){
			Seller sell = new Seller();
			try {
				sell = service.saveSeller(newSeller);
			} catch (AlreadyExistException e) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
			}
			return ResponseEntity.status(HttpStatus.CREATED).body(sell.toString());
	}
	
	
}
