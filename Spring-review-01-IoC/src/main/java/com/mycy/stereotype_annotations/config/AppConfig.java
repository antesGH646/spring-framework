package com.mycy.stereotype_annotations.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Inside the stereotype annotation config file no need to add the object
 */
@Configuration//tells the Spring Container to follow the direction below
//tells the Spring Container to look for classes inside stereotype_annotations package
@ComponentScan()
public class AppConfig {
}
