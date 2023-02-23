package com.cydeo.model;

import lombok.Data;

//usually do not get @Component, because it doesn't have implementing methods
//it only has just attributes, setters, getters, etc
@Data
public class Comment {
    private String author;
    private String text;
}
