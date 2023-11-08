package com.mycy.stereotypeannotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * the purpose of this class is to create beans from the POJO classes
 */
public class StereoDemoApp {
    public static void main(String[] args) {
    //Create the Spring container based on annotations and configurations
        //tell it from which config file to take direction by passing its name
        ApplicationContext context =
                new AnnotationConfigApplicationContext(CourseConfig.class);

        //tell the container to create beans by passing the class name, calls a method
        context.getBean(Java.class).getTeachingHours();//creates a bean then calls a method
    }
}
