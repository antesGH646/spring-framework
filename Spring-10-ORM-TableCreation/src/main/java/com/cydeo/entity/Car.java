package com.cydeo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity//marks to create a table from this Java object
@Table(name="cars")//giving it a custom name instead of using the default name
@NoArgsConstructor
@Data
public class Car {
    @Id//marks for Spring to use a primary key of this field
    @GeneratedValue(strategy = GenerationType.IDENTITY)//marks for postgres to generate unique values of the field
    private Long id;

    private String make;
    private String model;

    //creating a custom constructor excluding the id, the id will come from the postgres
    // this required custom method helps to create a car object & save it into the database
    public Car(String make, String model) {
        this.make = make;
        this.model = model;
    }
}
