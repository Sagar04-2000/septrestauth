package com.example.septrestauth.service;

import java.util.List;

import com.example.septrestauth.entity.User;

public interface UserService {

	String registerUser(User user);

	List<User> getAllUsers();

}
