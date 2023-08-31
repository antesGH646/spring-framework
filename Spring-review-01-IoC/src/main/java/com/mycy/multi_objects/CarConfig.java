package com.mycy.multi_objects;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class CarConfig {

    @Bean(name = "car1")
    @Primary//if you add primary, if you don't specify the object in the runner spring will take the default
    Car car1() {
        Car car = new Car();
        car.setMake("Nissan");
        return car;
    }

    //creating the same method, meaning adding another object to container
    @Bean(name = "car2")
    Car car2() {
        Car car = new Car();
        car.setMake("Toyota");
        return car;
    }
}
