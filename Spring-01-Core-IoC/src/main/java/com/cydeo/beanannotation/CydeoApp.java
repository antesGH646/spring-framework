package com.cydeo.beanannotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CydeoApp {
    public static void main(String[] args) {
        //creating container and telling it from which Config file to get direction
        //by passing the Config files name/s
        ApplicationContext container = new AnnotationConfigApplicationContext(
                ConfigApp.class, ConfigAny.class);//can pass multiple Config files

        //telling the container to store what type of bean by passing the class name
       FullTimeMentor fm  = container.getBean(FullTimeMentor.class);//means: create a bean from this class
       fm.createAccount();

      //for multiple objects of the same type it is specified in the Configuration by give
      // it a name inside the @Bean() annotation, here pass the name to tell the spring
       PartTimeMentor pm  = container.getBean("pt2",PartTimeMentor.class);
       pm.createAccount();

        String str = container.getBean("str1",  String.class);
        System.out.println(str.toUpperCase());

        System.out.println(container.getBean("str2",String.class).toLowerCase());

        Integer integer = container.getBean(Integer.class);
        System.out.println(integer.equals(100));
    }
}
