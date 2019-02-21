package com.apallapu.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apallapu.user.domain.User;
import com.apallapu.user.repository.UserRepository;

/**
 * @author ankamma pallapu
 *
 */
@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	UserRepository UserRepository;
	
	public UserController(UserRepository productRepository) {
		super();
		this.UserRepository = productRepository;
	}

	@PostMapping(value = "/user")
	public User save (@RequestBody User account){
		return UserRepository.save(account);
	}
	
	@GetMapping(value = "/user")
	public Iterable<User> all (){
		return UserRepository.findAll();
	}
	
	
	@PutMapping(value = "/user")
	public User update (@RequestBody User account){
		return UserRepository.save(account);
	}
	
	@DeleteMapping(value = "/user")
	public void delete (@RequestBody User account){
		UserRepository.delete(account);
	}
}
