package com.cydeo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/car")
public class CarController {

    @RequestMapping("/info1")//localhost:8080/car/info1?make=Honda
    public String carInfo(@RequestParam String make,  Model model) {
        model.addAttribute("make", make);
        return "/car/car-info";
    }

    @RequestMapping("/info2")//localhost:8080/car/info2?make=Honda&year=2019
    public String carInfo1(@RequestParam String make, @RequestParam Integer year,  Model model) {
        model.addAttribute("make", make);//make is the view that carries/pass the java object
        model.addAttribute("year", year);
        return "/car/car-info";
    }

    //make it optional, pass default value if a parameter is not entered in the end point
    @RequestMapping("/info3")//localhost:8080/car/info3
    public String carInfo2(@RequestParam(value = "make", required = false, defaultValue = "Tesla")
                               String make, Model model) {
        model.addAttribute("make", make);
        return "/car/car-info";
    }

    //path parameter, make the end points path dynamic by using curly braces
    @RequestMapping("/info4/{make}") //localhost:8080/car/info4/honda
    public String carInfo3(@PathVariable String make, Model model) {
        model.addAttribute("make", make);
        return "/car/car-info";
    }

    //path parameter, make the end points path dynamic by using curly braces
    @RequestMapping("/info5/{make}/{year}") //localhost:8080/car/info5/honda/2016
    public String carInfo4(@PathVariable String make, @PathVariable Integer year, Model model) {
        model.addAttribute("make", make);
        model.addAttribute("year", year);
        return "/car/car-info";
    }
}
