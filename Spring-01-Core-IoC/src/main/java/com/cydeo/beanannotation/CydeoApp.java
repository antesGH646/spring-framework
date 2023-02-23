package com.cydeo.beanannotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CydeoApp {
    public static void main(String[] args) {
        //creating container and telling it from which Config file to get direction
        //by passing the Config files name/s
        ApplicationContext container = new AnnotationConfigApplicationContext(
                ConfigApp.class, ConfigAny.class);//passing the Config file

        //telling the container what type of bean to create by passing the class name
       FullTimeMentor fm  = container.getBean(FullTimeMentor.class);
       fm.createAccount();

      //if you have multiple objects of the same type must specify it
      // in the Configuration, give it a name inside the @Bean() annotation
       PartTimeMentor pm  = container.getBean("pt2",PartTimeMentor.class);
       pm.createAccount();

       //creating beans/objects from classes that you didn't create or cannot edit
        String str = container.getBean(String.class);
        System.out.println(str.toUpperCase());
        Integer integer = container.getBean(Integer.class);
        System.out.println(integer.equals(100));
    }
}
