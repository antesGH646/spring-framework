package com.mycy.dependency_injection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Java1 {
    OfficeHours officeHours;

    @Autowired
    public Java1(OfficeHours officeHours) {
        this.officeHours = officeHours;
    }

    public void totalHours() {
        System.out.println("Total hours: " + (300 + officeHours.getHours()));
    }
}
