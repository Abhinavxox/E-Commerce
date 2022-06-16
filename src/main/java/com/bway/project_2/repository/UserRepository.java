package com.bway.project_2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bway.project_2.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	
	User findByUsernameAndPassword(String un, String psw);

}
