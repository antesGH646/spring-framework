package com.mycy.controller;

import com.mycy.model.Mentor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/mentor")
public class MentorController {


    @GetMapping("/register")
    public String showForm(Model model){

        model.addAttribute("mentor",new Mentor());
        //to display the list into the UI form
        List<String> batchList = Arrays.asList("JD1","JD2","EU1","EU2","B18","B20");
        model.addAttribute("batchList",batchList);

        return "mentor/mentor-register";
    }

    //we can have different http methods for the same end point
    @PostMapping("/confirm")
    public String showForm2(@ModelAttribute("mentor") Mentor mentor){
        System.out.println(mentor.toString());
        return "mentor/mentor-confirmation";
        // we can have different http methods for the same end point
        // return "redirect:/mentor/register";
    }

}
