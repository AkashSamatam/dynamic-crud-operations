package com.example.demo.service.impli;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entities.Users;
import com.example.demo.Repository.user_repo;
import com.example.demo.payloads.users_dto;
import com.example.demo.service.user_service;

@Service

public class user_service_impli implements user_service {

	@Autowired
	user_repo repo;
	
	@Autowired
	ModelMapper modelmapper;
	
	@Override
	public users_dto adduser(users_dto dto) {
		
		Users users= this.users_dtotoUsers(dto);
		
		Users saveusers =this.repo.save(users);
		
		return this.Userstouser_dto(saveusers);
	}

	@Override
	public List<users_dto> get_users() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public users_dto getbyid(int userid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteuser(int userid) {
		// TODO Auto-generated method stub

	}

	@Override
	public users_dto update_user(users_dto dto, int userid) {
		// TODO Auto-generated method stub
		return null;
	}
	public Users users_dtotoUsers(users_dto dto) {
		
		Users users = this.modelmapper.map(dto, Users.class);
		
		return users;
	}
	
	public users_dto Userstouser_dto(Users users) {
		
		users_dto dto = this.modelmapper.map(users,users_dto.class);
		
		return dto;
	}
	
	

}
