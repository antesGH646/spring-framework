package com.cydeo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping ("/rs")//pass the name, associates responding to the http request
    public String ourRestaurant() {
        return "restaurant.html"; //returns the html name
    }

    @RequestMapping ("/home")//pass the name
    public String home() {
        return "home.html"; //returns the html name requested to display on the browser
    }

    @RequestMapping ("/welcome")//pass the name
    public String welcome() {
        return "welcome.html"; //returns the html name
    }
}
