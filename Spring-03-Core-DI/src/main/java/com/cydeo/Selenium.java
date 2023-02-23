package com.cydeo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component //to tell Spring Container create a bean from this class
public class Selenium {
    OfficeHours officeHours;

    @Autowired //to tell the Spring a bean of the OfficeHours
    public Selenium(OfficeHours officeHours) {
        this.officeHours = officeHours;
    }

    public void getTeachingHours() {
        System.out.println("Total teaching hours: " + (350 + officeHours.getHours()));
    }
}
