package com.example.demo.Exception_handling;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{

	String ResourceName;
	String Resourcefield;
	int Resourcevalue;
	
	public ResourceNotFoundException(String ResourceName,String Resourcefield,int Resourcevalue) {
		
		super(String.format("%s:user not found with %s:%s", ResourceName,Resourcefield,Resourcevalue));

	    this.ResourceName=ResourceName;
	    
	    this.Resourcefield=Resourcefield;
	    
	    this.Resourcevalue=Resourcevalue;
	    
		
	}
	
}
