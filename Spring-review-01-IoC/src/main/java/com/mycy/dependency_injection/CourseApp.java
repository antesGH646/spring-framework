package com.mycy.dependency_injection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CourseApp {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(CourseApp.class);
        Java1 java = context.getBean(Java1.class);
        java.totalHours();
    }
}
