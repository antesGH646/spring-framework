package com.mycy.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ComponentScan(basePackages = "com.cydeo")
//if you are passing multiple packages use curly braces
@ComponentScan(basePackages = {"com.mycy.proxy", "com.mycy.service", "com.mycy.repository"})
public class ProjectConfig {
}
