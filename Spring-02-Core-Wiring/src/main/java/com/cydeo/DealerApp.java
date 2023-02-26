package com.cydeo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DealerApp {
    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(ConfigCar.class);
        Car c = context.getBean(Car.class);
        Person person = context.getBean(Person.class);
        System.out.println("Persons name: " + person.getName());
        System.out.println("Car's make: " + c.getMake());
        //prints null if you do not wire it in the @Bean annotated methods
        System.out.println(person.getName() + "'s car: " + c.getMake());
    }
}
