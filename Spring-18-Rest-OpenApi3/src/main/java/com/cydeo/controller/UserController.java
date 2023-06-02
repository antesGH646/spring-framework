package com.cydeo.controller;

import com.cydeo.entity.User;
import com.cydeo.repository.UserRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")//  /api/v1 endpoint
@Tag(name = "User", description = "User CRUD Operations")//swagger tag
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/users")// /api/v1/users endpoint
    @Operation(summary = "Read all users")//adds summarized explanation for the endpoints
    //to display the status code responses and their description on Swagger page
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved users (OK)",
                    content = {@Content(mediaType = "application/json")}),
            //adding content = @Content removes the json body example from displaying on the Swagger page
            @ApiResponse(responseCode = "400", description = "Something went wrong", content = @Content),
            @ApiResponse(responseCode = "404", description = "Not Found", content = @Content)
    })
    public List<User> readAllUsers() {
        return userRepository.findAll();
    }
}
