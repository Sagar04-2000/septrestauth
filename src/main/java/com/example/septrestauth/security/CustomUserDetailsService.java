package com.example.septrestauth.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.septrestauth.entity.User;
import com.example.septrestauth.repo.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
	UserRepository userrepo;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		Optional<User> user = userrepo.findByUsername(username);
		
		if(user.isEmpty()) {
			return null;
		} else {
			return org.springframework.security.core.userdetails.User.
					withUsername(user.get().getUsername()).
					password(user.get().getPassword()).
					build();					
		}
		
		
		
	}

}
