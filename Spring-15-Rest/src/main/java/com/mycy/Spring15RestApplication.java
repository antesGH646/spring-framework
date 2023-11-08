package com.mycy;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Spring15RestApplication {

	public static void main(String[] args) {
		SpringApplication.run(Spring15RestApplication.class, args);
	}

	@Bean //create a bean of ModelMapper b/c it was created by somebody else
	public ModelMapper mapper () {
		return new ModelMapper();
	}
}
