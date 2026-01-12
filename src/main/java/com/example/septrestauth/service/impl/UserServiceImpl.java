package com.example.septrestauth.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.septrestauth.entity.User;
import com.example.septrestauth.repo.UserRepository;
import com.example.septrestauth.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	PasswordEncoder encoder;
	
	@Override
	public String registerUser(User user) {
		// TODO Auto-generated method stub
		if(user!=null) {
			System.out.println("User "+user.getUsername());
			System.out.println("User Password "+user.getPassword());
			user.setPassword(encoder.encode(user.getPassword()));
			user=userRepository.save(user);
			System.out.println("After saved user ID"+user.getId());
			
			return "User with username "+user.getUsername() +" saved with ID= "+user.getId();
		}
		return "User not registered";
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return userRepository.findAll();   //select * from users;
	}

	
}
