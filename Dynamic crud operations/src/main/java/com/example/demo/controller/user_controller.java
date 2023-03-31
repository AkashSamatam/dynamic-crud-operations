package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.payloads.users_dto;
import com.example.demo.service.user_service;

@RestController
@RequestMapping("/api/v1")
public class user_controller {

	@Autowired
	user_service user_serv;
	@PostMapping("/create_user")
	public ResponseEntity<users_dto>  addusers(@RequestBody users_dto dto) {
		
		users_dto d= this.user_serv.adduser(dto);
		
		return new ResponseEntity<>(d,HttpStatus.ACCEPTED);
		
	}
}
