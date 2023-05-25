package com.cydeo.controller;

import com.cydeo.dto.User;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@RestController
@RequestMapping("/users")
public class Consume_RestTemplate {

    //stores the API that needs to be consumed in this API
    private final String URI = "https://jsonplaceholder.typicode.com/users";
    private final RestTemplate restTemplate;

    //inject RestTemplate
    public Consume_RestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    /**
     * This method return a list of Users consuming from a third party URL
     * Uses RestTemplate class, but 1st create the bean in the runner class
     * Cannot post into a third party API, therefore, you have to use
     * the @GetMapping annotation and the getForEntity() method which gets
     * the Json body and maps it to this dto and accepts the URI and
     * the Array class that you want to map into.
     */
    @GetMapping//http://localhost:8080/users
    public User[] readAllUsers() {
        ResponseEntity<User[]> responseEntity = restTemplate.getForEntity(URI, User[].class);
        return responseEntity.getBody();
    }

    /**
     * This method returns a user by id endpoint path
     * consuming it from a third party URL
     * Want retrieve certain user using ID path
     * getForObject() does not need to map, it just
     * returns an object
     *  @param id Integer, pass integer endpoint
     *  @return Object
     */
    @GetMapping("{id}")//http://localhost:8080/users/2
    public Object fetchUser(@PathVariable("id") Integer id) {
        String URL = URI + "/{id}";
        return restTemplate.getForObject(URL, Object.class,id);
    }

    /**
     * When consuming a third party API, some API require to enter some
     * headers for security purposes. HttpHeaders class works with headers.
     * exchange() method from RestTemplate is used when you want to pass
     * something.
     * It accepts:
     *     -the URL that you want to consume
     *     -type of Http method
     *     -Http entity object
     *     -class name
     * @return ResponseEntity Object
     */
    @GetMapping("/test")
    public ResponseEntity<Object> consumeFromDummyApi() {
        //creating Http header to pass the key and values
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.set("app-id","6298ebfecd0551211fce37a6");
        //creating the HttpEntity to pass the Header
        HttpEntity<String> entity = new HttpEntity<>(headers);
        //Creating ResponseEntity to pass the HttPEntity
        ResponseEntity<Object> response =
                restTemplate.exchange("https://dummyapi.io/data/v1/user/?limit=10", HttpMethod.GET,entity, Object.class);
       //returning the response entity
        return response;
    }
}
