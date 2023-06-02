package com.cydeo.controller;

import com.cydeo.entity.Cinema;
import com.cydeo.repository.CinemaRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")// endpoint baseurl/api/v1
@Tag(name = "Cinema", description = "Cinema CRUD Operations")//adding tags for the endpoint
public class CinemaController {

    private final CinemaRepository cinemaRepository;

    public CinemaController(CinemaRepository cinemaRepository) {
        this.cinemaRepository = cinemaRepository;
    }

    @GetMapping("/cinemas")//endpoint baseurl/api/v1/cinemas
    @Operation(summary = "Read all cinemas")//adds summarized explanation for the endpoints
    public List<Cinema> readAllCinemas(){//displaying a list of objects/(json body example) from the db
        return cinemaRepository.findAll();
    }
}
