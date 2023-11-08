package com.mycy.model;

import lombok.Data;

/**
 * model or entity classes usually do not get @Component, because they don't have implementing methods
 * they only have attributes, setters, getters, etc.
 * If you are using the lombok annotations you do not need to create constructors
 * and initialize the variable, no need to use the @Autowired annotation
 * model package is used to store encapsulated classes that define the
 * attributes used by the methods that implement the business logic
 * (business logic means the USs, ACs, TCs, etc.)
 * the common practice is to use lombok annotations instead of generating getters and
 * setters.
 */
@Data
public class Comment {
    //define attributes needed in the behaviors in implementing the business logic
    private String author;
    private String text;
}
