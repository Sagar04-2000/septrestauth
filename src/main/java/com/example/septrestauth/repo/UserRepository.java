package com.example.septrestauth.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.septrestauth.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long>{
	
	//select * from user where id = ? 
	Optional<User> findById(Long id);
	
	//select * from user where username = ?
	Optional<User> findByUsername(String username);
	
	// select * from user where age= ?1 and city=?2
	User findByAgeAndCity(Long age,String city);
	
	//List<User> findByAgeOrderByDesc(Long age);
	
	
	/*@Query(value= ("Select * from user where age= ?1"))
	User findByAgeOrderByDesc2(Long age);*/

}
