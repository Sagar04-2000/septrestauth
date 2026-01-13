package com.example.septrestauth.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.septrestauth.entity.User;
import com.example.septrestauth.repo.UserRepository;
import com.example.septrestauth.service.UserService;

@RestController
public class UserController {

	@Autowired
	UserService userService;
	
	@Autowired
	UserRepository userRepo;

	
	@Value("${sid.academy.test.for.spring.value} : defaultBucket")
	private String dynamicValue;

	
	@GetMapping("/")
	public String test() {
		return "Hello From Spring Rest Auth" + dynamicValue;
	}
	
	@PostMapping("/register")
	public String registerUser(@RequestBody User user) {
		return userService.registerUser(user);
	}
	
	@GetMapping("/getUsers")
	public List<User> getAllUsers(){
		return userService.getAllUsers();
	}
}
