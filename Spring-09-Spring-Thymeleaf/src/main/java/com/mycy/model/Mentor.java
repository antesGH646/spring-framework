package com.mycy.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Mentor {
    //these variables are declared from the UI elements
    private String firstName;
    private String lastName;
    private String email;
    private String gender;
    private String batchNumber;
    private boolean graduated;
    private String comment;

}
