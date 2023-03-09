package com.cydeo.controller;

import com.cydeo.enums.Gender;
import com.cydeo.model.Mentor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("m1")//adds a path m1/
public class MentorController {

    @RequestMapping("/mentor")//localhost:8080/m1/mentor
    public String mentor(Model model) {
        List<Mentor> mentorList = new ArrayList<>() {};
            mentorList.add(new Mentor("Adam","Smith",45, Gender.MALE));
            mentorList.add(new Mentor("James","Bond",42, Gender.MALE));
            mentorList.add(new Mentor("Marry","Anderson",35, Gender.FEMALE));
            //accepts 2 params: a name to use in the Thymeleaf, the data or object to integrate
            model.addAttribute("mentors", mentorList);//mentor is the view that carries the java object
        //the package name / the thymeleaf name, might need slash in the beginning
        return "/mentor/mentor-list";
    }
}
