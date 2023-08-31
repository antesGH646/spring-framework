package com.mycy.bean_annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration//labeling that this class is a configuration class
public class NewAppConfig {
    //String class is a class that you don't own so use the @Bean annotation to use an object from it
    @Bean(name = "String 1")//tells the Spring Container to put this specific object inside it
    public String str1(){
        return "Welcome to CydeoApp";
    }

    @Primary
    @Bean//tells the Spring Container to put this specific object inside it
    public String str2(){
        return "Spring Core Practice";
    }
}
