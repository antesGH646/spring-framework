package com.cydeo.bootstrap;

import com.cydeo.entity.Car;
import com.cydeo.repository.CarRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataGenerator implements CommandLineRunner{
    //need reference to call methods such as save(), etc
    CarRepository carRepository;

    //to inject by constructor
    public DataGenerator(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Car c1 = new Car("BMW", "M5");
        Car c2 = new Car("Honda", "Civic");
        Car c3 = new Car("Toyota", "Corolla");

        //calling save() to add the objects
        carRepository.save(c1);
        carRepository.save(c2);
        carRepository.save(c3);
    }
}
