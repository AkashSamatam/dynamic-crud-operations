package com.example.demo.payloads;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class users_dto {

	private int userid;
	
	private String username;
	
	private String email;
	
	private String password;
	
}
