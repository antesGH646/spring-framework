package com.cydeo.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * This package occupies the config files
 * In the config file pass the folders path of the packages as an argument
 * in which the classes with @Component annotation are found. If you have more than one package
 * use curly braces, and separate the package names by commas.
 */
@Configuration
//@ComponentScan(basePackages = "com.cydeo")
//if you are passing multiple packages use curly braces
@ComponentScan(basePackages = {"com.cydeo.proxy", "com.cydeo.service", "com.cydeo.repository"})
public class ProjectConfig {
}
