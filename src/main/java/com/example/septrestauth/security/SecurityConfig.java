package com.example.septrestauth.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) {
		//we need to define the endpoints whhich should be restricted or permitted by all
		
		http.csrf(csrf->csrf.disable())
			.authorizeHttpRequests(
					
					request -> request.requestMatchers("/","/register").permitAll()// --Anyone can access these reuqets
					.anyRequest().authenticated()
					
					).httpBasic(Customizer.withDefaults());
		
		return http.build();
	}
	
	
	@Bean
	@Primary
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	PasswordEncoder scryptPasswordEncoder() {
		return SCryptPasswordEncoder.defaultsForSpringSecurity_v5_8();
	}
}

