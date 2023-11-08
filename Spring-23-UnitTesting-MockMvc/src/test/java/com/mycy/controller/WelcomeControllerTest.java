package com.mycy.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(WelcomeController.class)//marks to get all the beans from this class only
class WelcomeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void welcome() throws Exception {

        //create a request using RequestBuilder and MockMvcRequestBuilders
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/welcome")
                .accept(MediaType.APPLICATION_JSON);//want to see it in json format
        //send the request using perform() method, store it in a MvcResult object for verification
        MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();
        //verifying if the response status code is 200
        assertEquals(200, mvcResult.getResponse().getStatus());
        //verifying the response endpoint is welcome
        assertEquals("welcome", mvcResult.getResponse().getContentAsString());
    }

    /**
     * MockMvc is used to mock http controllers
     * throws Exception
     */
    @Test
    void welcome2() throws Exception {

        //create a request using RequestBuilder and MockMvcRequestBuilders
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/welcome")
                .accept(MediaType.APPLICATION_JSON);//want to see it in json format
        //returning the request
        mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().string("welcome"))
                .andReturn();
    }
}