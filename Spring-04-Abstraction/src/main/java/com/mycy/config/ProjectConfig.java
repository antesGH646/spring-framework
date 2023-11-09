package com.mycy.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * This package occupies the config files
 * In the config file pass the folders path of the packages as an argument
 * in which the classes with @Component annotation are found. If you have more than one package
 * use curly braces, and separate the package names by commas.
 */
@Configuration
//@ComponentScan(basePackages = "com.mycy")
//if you are passing multiple packages use curly braces
@ComponentScan(basePackages = {"com.mycy.proxy", "com.mycy.service", "com.mycy.repository"})
public class ProjectConfig {
}
