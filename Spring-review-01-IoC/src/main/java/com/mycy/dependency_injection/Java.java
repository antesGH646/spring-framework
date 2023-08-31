package com.mycy.dependency_injection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Java {
    OfficeHours officeHours;

    @Autowired //injecting through constructor and @Autowired annotation
    public Java(OfficeHours officeHours) {
        this.officeHours = officeHours;
    }

    //suppose that method is performing a certain task
    public void getHours() {
        System.out.println("Total Hours: " + (300 + officeHours.getHours()));
    }
}
