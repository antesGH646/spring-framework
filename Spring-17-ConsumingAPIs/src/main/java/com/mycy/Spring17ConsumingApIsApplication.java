package com.mycy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableFeignClients//no need to create a bean
public class Spring17ConsumingApIsApplication {

    public static void main(String[] args) {
        SpringApplication.run(Spring17ConsumingApIsApplication.class, args);
    }

    @Bean//creating a bean, b/c it was created by somebody else (3rd party)
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
