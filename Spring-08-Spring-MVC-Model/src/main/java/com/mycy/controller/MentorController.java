package com.mycy.controller;

import com.mycy.enums.Gender;
import com.mycy.model.Mentor;
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
            //addAttribute() accepts 2 parameters: Thymeleaf name to integrate and Java object
            model.addAttribute("mentors", mentorList);//mentors carries the java object for integration in the Thymeleaf
        return "/mentor/mentor-list";//the packageName/thymeleafName, might need slash in the beginning
    }
}
