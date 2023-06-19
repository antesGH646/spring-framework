package com.cydeo.client;

import com.cydeo.dto.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(url = "https://jsonplaceholder.typicode.com", name = "USERS-CLIENT")//base url of the consumed url
public interface ConsumeUrlUsersClient {
    //when you call this method will hit the above URL and trigger the Get method
    @GetMapping("/users")
    List<User> getUsers();
}
