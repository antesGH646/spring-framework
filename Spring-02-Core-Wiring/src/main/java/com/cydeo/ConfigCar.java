package com.cydeo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigCar {

    //telling Spring to create an object from Car, and inject it when called by other objects
    @Bean
    Car car() {
        Car car = new Car();
        car.setMake("Honda");
        return car;
    }

    //Person object wants to use Car object, creating Has-A relationship through Autowiring, passing object
    @Bean
    Person person(Car car) {
        Person person = new Person();
        person.setName("James Bond");
        person.setCar(car); //passing the object reference
        return person;
    }
}
