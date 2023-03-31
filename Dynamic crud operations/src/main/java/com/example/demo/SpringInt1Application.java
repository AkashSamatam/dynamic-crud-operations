package com.example.demo;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringInt1Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringInt1Application.class, args);
	}
	
	@Bean
	public ModelMapper modelmapper() {
		
		return new ModelMapper();
	}

}
