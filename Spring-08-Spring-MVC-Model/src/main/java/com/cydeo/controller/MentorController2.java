package com.cydeo.controller;

import com.cydeo.enums.Gender;
import com.cydeo.model.Mentor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("m2")
public class MentorController2 {

    @RequestMapping("/mentor")//localhost:8080/m2/mentor
    public String mentor(Model model) {
        List<Mentor> mentorList = new ArrayList<>() {};
            mentorList.add(new Mentor("Samsom","Goitom",22, Gender.MALE));
            mentorList.add(new Mentor("Honey","Bell",26, Gender.FEMALE));
            mentorList.add(new Mentor("Anish","Kumar",15, Gender.FEMALE));
            //accepts 2 params: a name to use in the Thymeleaf, the data or object to integrate
            model.addAttribute("mentors", mentorList);
        //the package name / the thymeleaf name, might need slash in the beginning
        return "/mentor/mentor-list";
    }
}
