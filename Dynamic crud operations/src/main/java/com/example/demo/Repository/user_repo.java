package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entities.Users;

public interface user_repo extends JpaRepository<Users, Integer> {
	
	
}
