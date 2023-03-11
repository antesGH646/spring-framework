package com.cydeo.controller;

import com.cydeo.bootstrap.DataGenerator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller//to create a bean and mark the java controller class
@RequestMapping("/student") //point the student end point into the method that points into the html
public class StudentController {

    // @RequestMapping(value = "/register",method = RequestMethod.GET)
    @GetMapping("/register") //adding /register end point
    public String register(Model model){

        model.addAttribute("students", DataGenerator.createStudent());

        return "student/register";
    }

    //    @RequestMapping("/welcome")
    @GetMapping("/welcome")
    public String info(){
        return "student/welcome";
    }
}
