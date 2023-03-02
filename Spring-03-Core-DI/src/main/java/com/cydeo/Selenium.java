package com.cydeo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component //a mark directing the Spring Container to create a bean out of this class
public class Selenium {
    OfficeHours officeHours;

    @Autowired //to tell the Spring to create a bean of the OfficeHours
    public Selenium(OfficeHours officeHours) {
        this.officeHours = officeHours;
    }

    public void getTeachingHours() {
        System.out.println("Total teaching hours: " + (350 + officeHours.getHours()));
    }
}
