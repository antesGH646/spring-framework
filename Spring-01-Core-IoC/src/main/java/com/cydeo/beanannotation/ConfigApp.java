package com.cydeo.beanannotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * A Configuration class with @Configuration annotation
 * This class tells the Spring which objects to create and manage
 *
 * This configuration class have methods with @Bean annotation
 * The methods return the objects that need to be stored in the
 * context or the Spring container
 */

@Configuration
public class ConfigApp {

    @Bean()
    FullTimeMentor fullTimeMentor() {
        return new FullTimeMentor();
    }

  //  @Bean(name = "pt1")
    @Bean
    @Primary //this is the default one, a bean is created from class type by default
    PartTimeMentor partTimeMentor() {
        return new PartTimeMentor();
    }

    @Bean(name = "pt2")//a bean will be created when specified inside the getBean() method
    PartTimeMentor partTimeMentor2() {
        return new PartTimeMentor();
    }
}
