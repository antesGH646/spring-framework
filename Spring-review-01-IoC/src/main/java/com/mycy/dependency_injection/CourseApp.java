package com.mycy.dependency_injection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CourseApp {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(CourseApp.class);
        Java java = context.getBean(Java.class);
        java.getHours();
    }
}
