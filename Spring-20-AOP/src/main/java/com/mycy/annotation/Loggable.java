package com.mycy.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})//defining the target to be used on method level
@Retention(RetentionPolicy.RUNTIME)//defining the retention to run at run time
public @interface Loggable {} //annotations are marked with @interface, named Loggable