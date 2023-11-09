package com.mycy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller//tells Spring that this class has methods that return endpoints that display views
public class HomeController {

    @RequestMapping ("/rs")//rs is the end point, responds to the http request
    public String ourRestaurant() {
        return "restaurant.html"; //returns the html name that is displayed to the UI
    }

    @RequestMapping ("/home")//pass the name of the end point
    public String home() {
        return "home.html"; //returns the html name requested to display on the browser
    }

    @RequestMapping ("/welcome")//pass the name
    public String welcome() {
        return "welcome.html"; //returns the html name
    }
}
