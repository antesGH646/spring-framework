package com.cydeo.controller;

import com.cydeo.client.ConsumeSecureUrlClient;
import com.cydeo.client.ConsumeUrlUsersClient;
import com.cydeo.dto.ResponseWrapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Consume_FeignClient {
    private final ConsumeUrlUsersClient consumeUrlUsersClient;
    private final ConsumeSecureUrlClient consumeSecureUrlClient;

    public Consume_FeignClient(ConsumeUrlUsersClient userClient,
                               ConsumeSecureUrlClient employeeClient) {
        this.consumeUrlUsersClient = userClient;
        this.consumeSecureUrlClient = employeeClient;
    }

    @GetMapping("/api/v1/users")//http://localhost:8080/api/v1/users
    public ResponseEntity<ResponseWrapper> getUsers(){
        return ResponseEntity.ok(new ResponseWrapper("Retrieved list of users", consumeUrlUsersClient.getUsers()));
    }

    @GetMapping("/api/v1/employee")//http://localhost:8080/api/v1/employee
    public ResponseEntity<ResponseWrapper> getEmployee() {
        return ResponseEntity.ok(new ResponseWrapper("Retrieved Employee ", consumeSecureUrlClient.getEmployee("6298ebfecd0551211fce37a6")));
    }
}
