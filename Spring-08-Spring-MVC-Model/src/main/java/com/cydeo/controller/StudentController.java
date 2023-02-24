package com.cydeo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StudentController {

    @RequestMapping("/welcome")
    public String student(Model model) {
        //want to past data to html, Model is an interface that carries data to view
        model.addAttribute("name", "Cydeo");
        model.addAttribute("course", "MVC");
        return "student/welcome"; //Thymeleaf template not an html file
    }
}
