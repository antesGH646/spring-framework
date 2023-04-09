package com.cydeo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="cars")//give it a name instead of the default name
@NoArgsConstructor
@Data
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String make;
    private String model;

    //need custom constructor without id
    // helps to create car object & save it in the database
    public Car(String make, String model) {
        this.make = make;
        this.model = model;
    }
}
