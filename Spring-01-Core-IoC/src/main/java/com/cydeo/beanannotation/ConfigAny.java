package com.cydeo.beanannotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration//marking to tell the context to create beans from the below classes
public class ConfigAny {

    //creating beans/objects from classes that you didn't create or cannot edit
    @Bean(name="str1") //there are two String types specifying from which one to create a bean
    String string() {
        return "Developer";
    }

    @Bean(name = "str2") //there are two String types specifying from which one to create a bean
    String string2() {
        return "Tester";
    }

    @Bean
    Integer integer() {
        return 100;
    }
}
