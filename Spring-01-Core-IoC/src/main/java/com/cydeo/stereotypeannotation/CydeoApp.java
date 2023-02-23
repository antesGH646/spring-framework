package com.cydeo.stereotypeannotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * the purpose of this class is to create beans from the POJO classes
 */
public class CydeoApp {
    public static void main(String[] args) {
    //Create the Spring container based on annotations and configurations
        //tell it from which config file to take direction by passing its name
        ApplicationContext context =
                new AnnotationConfigApplicationContext(ConfigCourse.class);

        //tell the container from which class to create beans by passing the class name
        context.getBean(Java.class).getTeachingHours();//creates a bean then calls a method
    }
}
