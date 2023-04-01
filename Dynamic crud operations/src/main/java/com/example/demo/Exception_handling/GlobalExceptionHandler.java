package com.example.demo.Exception_handling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.demo.payloads.Api_Response;

@RestControllerAdvice


public class GlobalExceptionHandler {
@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<Api_Response> resourcenotfoundexception(ResourceNotFoundException Ex){
		
		String message = Ex.getMessage();
		
		Api_Response api = new Api_Response(message,false);
		
		return new ResponseEntity<Api_Response> (api,HttpStatus.NOT_FOUND);
	}
	
}
