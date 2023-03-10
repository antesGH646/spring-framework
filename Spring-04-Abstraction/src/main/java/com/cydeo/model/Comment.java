package com.cydeo.model;

import lombok.Data;

/**
 * usually do not get @Component, because it doesn't have implementing methods
 * it only has just attributes, setters, getters, etc
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
