package com.mycy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component //a mark directing the Spring Container to create a bean out of this class
public class Selenium {
    OfficeHours officeHours;

    /**
     * Since lombok annotation is not used in this component class, you need to create
     * a constructor and add the @Autowired annotation on the constructor level,
     * otherwise, Spring will throw a null pointer exception.
     * However, if you are using lombok annotations on the class level, Spring will inject
     * the bean automatically, you don't need to create a constructor and add @Autowired annotation.
     */
    @Autowired //tells Spring to create a bean and autowire it when called
    public Selenium(OfficeHours officeHours) {
        this.officeHours = officeHours;
    }

    public void getTeachingHours() {
        System.out.println("Total teaching hours: " + (350 + officeHours.getHours()));
    }
}
