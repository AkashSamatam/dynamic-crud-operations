package com.example.demo.service;

import java.util.List;

import com.example.demo.payloads.users_dto;

public interface user_service {

	users_dto adduser(users_dto dto);
	
	List<users_dto> get_users();
	
	users_dto getbyid(int userid);
	
	void deleteuser (int userid);
	
	users_dto update_user(users_dto dto,int userid);
		
	
}
