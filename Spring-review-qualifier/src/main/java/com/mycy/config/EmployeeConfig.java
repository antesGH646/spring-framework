package com.mycy.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.mycy")//will look all classes with @Component annotation inside the mycy package
public class EmployeeConfig {
}
