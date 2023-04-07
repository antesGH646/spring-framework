package com.cydeo.controller;

import com.cydeo.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Controller
public class StudentController {

    @RequestMapping("/welcome")
    public String student(Model model) {
        //want to past data to html, Model is an interface that carries data to view
        model.addAttribute("name", "Cydeo");//name is an added model attribute carrying the String "Cydeo"
        model.addAttribute("course", "Back end Development");

        //create a random id 0-1000 and show it in the UI
        int studentId = new Random().nextInt();
        model.addAttribute("id", studentId);//model attribute carrying the id
        model.addAttribute("subject", "MVC");//model attribute carrying String "MVC"

        //display array lists or an element from a list in the UI
        List<Integer> numbers = Arrays.asList(12,41,52,51,65,32,26);
        model.addAttribute("numbers", numbers);//numbers is an added model attribute carrying the list
       // model.addAttribute("numbers", numbers.get(3));

        Student student = new Student(1, "Adam", "Smith");
        model.addAttribute("student", student);

        return "student/welcome"; //Thymeleaf template not an html file
    }

}
