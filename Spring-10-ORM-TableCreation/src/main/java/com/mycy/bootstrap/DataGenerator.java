package com.mycy.bootstrap;

import com.mycy.entity.Car;
import com.mycy.repository.CarRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

//CommandLineRunner has the run method that accepts multiple arguments
@Component
public class DataGenerator implements CommandLineRunner {
    //need reference to call methods such as save(), etc
    CarRepository carRepository;

    //injecting by constructor
    public DataGenerator(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    /**
     * Run method accepts varargs, varargs is used to insert either zero or multiple arguments
     * instead of adding the arguments as arrays separated by commas can use 3 dots (...)
     * Var args reduces overloading of the constructor
     * @param args var args arguments
     * @throws Exception
     */
    @Override
    public void run(String... args) throws Exception {
        //creating car objects manually, the id comes automatically from postgres
        Car c1 = new Car("BMW", "M5");
        Car c2 = new Car("Honda", "Civic");
        Car c3 = new Car("Toyota", "Corolla");

        //calling save() method from Repository to add the objects
        carRepository.save(c1);
        carRepository.save(c2);
        carRepository.save(c3);
    }
}
