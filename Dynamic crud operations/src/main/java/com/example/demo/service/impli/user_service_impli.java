package com.example.demo.service.impli;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entities.Users;
import com.example.demo.Exception_handling.ResourceNotFoundException;
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
		List<Users> list= this.repo.findAll();
		
		List<users_dto> dto =list.stream().map(user->this.Userstouser_dto(user)).collect(Collectors.toList());
		return dto;
	}

	@Override
	public users_dto getbyid(int userid) {
		
		Users users = this.repo.findById(userid).orElseThrow(()->new ResourceNotFoundException("Users","userid",userid));
		
		
		return this.Userstouser_dto(users);
	}

	@Override
	public void deleteuser(int userid) {
		
		Users users = this.repo.findById(userid).orElseThrow(()->new ResourceNotFoundException("Users", "userid", userid));
		
		this.repo.delete(users);

	}

	@Override
	public users_dto update_user(users_dto dto, int userid) {
		
		Users users = this.repo.findById(userid).orElseThrow(()->new ResourceNotFoundException("Users", "userid", userid));
	
		users.setUsername(dto.getUsername());
		
		users.setEmail(dto.getEmail());
		
		users.setPassword(dto.getPassword());
		
		Users update_users = this.repo.save(users);
		
		users_dto userdto = this.Userstouser_dto(update_users);
		
		return  userdto;
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
