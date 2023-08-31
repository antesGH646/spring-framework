package com.mycy.dependency_injection;

import org.springframework.stereotype.Component;

@Component
public class DevOps {

    //suppose that method is performing a certain task
    public void totalCreditHours() {
        System.out.println("Total Hours: " + 190);
    }
}
