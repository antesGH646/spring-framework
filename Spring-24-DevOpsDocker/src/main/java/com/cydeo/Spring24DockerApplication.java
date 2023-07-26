package com.cydeo;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class Spring24DockerApplication {

    public static void main(String[] args) {
        SpringApplication.run(Spring24DockerApplication.class, args);
    }

    @Bean
    public ModelMapper mapper(){
        return new ModelMapper();
    }

    /**
     * This method encodes user's password
     * BCryptPasswordEncoder implements PasswordEncoder interface
     * such as the matches() abstract method
     * @return Encrypted encoded password
     */
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
