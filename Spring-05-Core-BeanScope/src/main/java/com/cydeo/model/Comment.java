package com.cydeo.model;

import lombok.Data;

//usually do not get @Component, do not have implementing methods
//are just attributes, setters, getters, etc
@Data
public class Comment {
    private String author;
    private String text;
}
