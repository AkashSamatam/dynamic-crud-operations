package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.payloads.Api_Response;
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
	@GetMapping("/get_allusers")
	public ResponseEntity<List<users_dto>> get_allusers(){
		
		return ResponseEntity.ok(this.user_serv.get_users());
	}
	
	@GetMapping("/getbyid/{userid}")
	public ResponseEntity<users_dto>  getbyid(@PathVariable int userid){
		
		return ResponseEntity.ok(this.user_serv.getbyid(userid));
	}
	@DeleteMapping("/deleteuser/{userid}")
	public ResponseEntity<Api_Response> deleteusers(@PathVariable int userid){
		
		this.user_serv.deleteuser(userid);
		
		return new ResponseEntity(new Api_Response("user deleted successfully",true),HttpStatus.OK);
	}
	@PutMapping("/updateuser/{userid}")
	public ResponseEntity<users_dto> updated_users(@RequestBody users_dto dto,@PathVariable int userid){
		
		users_dto userdto = this.user_serv.update_user(dto, userid);
		
		return ResponseEntity.ok(userdto);
	}
}
