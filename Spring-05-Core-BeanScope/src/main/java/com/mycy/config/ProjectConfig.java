package com.mycy.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration//marks that this class is a configuration class
//@ComponentScan(basePackages = "com.mycy")

//marks for Spring to look component class in the following packages
// if you are passing multiple packages use curly braces
@ComponentScan(basePackages = {"com.mycy.proxy", "com.mycy.service", "com.mycy.repository"})
public class ProjectConfig {
}
