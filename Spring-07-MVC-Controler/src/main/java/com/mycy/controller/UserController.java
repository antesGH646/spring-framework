package com.mycy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller//tells Spring that this class has methods that return endpoints that display views
public class UserController {

    @RequestMapping("/user")
    public String user(){
        return "/user/userinfo.html";  //directs user folder under static folder
    }
}
