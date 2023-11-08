package com.mycy.controller;

import com.mycy.entity.Account;
import com.mycy.entity.User;
import com.mycy.repository.AccountRepository;
import com.mycy.repository.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController//marks that this class is Rest API Controller
public class HomeController {

    private final UserRepository userRepository;
    private final AccountRepository accountRepository;

    public HomeController(UserRepository userRepository,
                          AccountRepository accountRepository) {
        this.userRepository = userRepository;
        this.accountRepository = accountRepository;
    }

    @GetMapping("/users")
    public List<User> readAllUsers(){
        return userRepository.findAll();
    }

    @GetMapping("/accounts")
    public List<Account> readAllAccounts(){
        return accountRepository.findAll();
    }
}