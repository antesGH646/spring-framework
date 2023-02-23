package com.cydeo.stereotypeannotation;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration //directs context to create beans from the directions below

//directing Spring to look POJOs outside in different package
//@ComponentScan(basePackages = "cydeo.loosely_coupled")

@ComponentScan //directs Spring to scan POJOs inside the current package with @Component
public class ConfigCourse {}
