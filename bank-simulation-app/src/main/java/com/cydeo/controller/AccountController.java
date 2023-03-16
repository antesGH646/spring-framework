package com.cydeo.controller;

import com.cydeo.service.AccountService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AccountController {
    //define a service, but need to create a constructor t
    private final AccountService accountService;

    //a constructor
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/index")
    public String getIndex(Model model) {
        model.addAttribute("accountList", accountService.listAllAccount());
        return "accounts/index";//returns the index html file from the accounts sub folder under the templates
    }

}
