package com.cydeo.controller;

import com.cydeo.entity.Genre;
import com.cydeo.entity.MovieCinema;
import com.cydeo.repository.GenreRepository;
import com.cydeo.repository.MovieCinemaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class Consume_WebClient {

    private final MovieCinemaRepository movieCinemaRepository;
    private final GenreRepository genreRepository;

    public Consume_WebClient(MovieCinemaRepository movieCinemaRepository,
                             GenreRepository genreRepository) {
        this.movieCinemaRepository = movieCinemaRepository;
        this.genreRepository = genreRepository;
    }

    @GetMapping("/flux-movie-cinema")//http://localhost:8080/flux-movie-cinema
    public Flux<MovieCinema> readAllMovieCinemaFlux() {
        return Flux.fromIterable(movieCinemaRepository.findAll());
    }

//    @GetMapping("/mono-movie-cinema/{id}")//http://localhost:8080/mono-movie-cinema/3
//    public Mono<MovieCinema> readMovieCinemaById(@PathVariable("id") Long id) {
//        return Mono.just(movieCinemaRepository.findById(id).get());//.get() added b/c it is Optional
//    }

    //can create and endpoint using ResponseEntity too
    @GetMapping("/mono-movie-cinema/{id}")//http://localhost:8080/mono-movie-cinema/3
    public ResponseEntity<Mono<MovieCinema>> getMovieCinemaById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(Mono.just(movieCinemaRepository.findById(id).get()));//.get() added b/c it is Optional
    }

    @PostMapping("/create-genre")
    public Mono<Genre> createGenre(@RequestBody Genre genre) {
        Genre createGenre = genreRepository.save(genre);
        return Mono.just(createGenre);
    }

    @DeleteMapping("/delete/genre/{id}")
    public Mono<Void> deleteGenre(@PathVariable("id") Long id){
        genreRepository.deleteById(id);
        return Mono.empty();
    }
}
