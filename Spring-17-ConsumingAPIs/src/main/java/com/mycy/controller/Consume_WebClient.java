package com.mycy.controller;

import com.mycy.entity.Genre;
import com.mycy.entity.MovieCinema;
import com.mycy.repository.GenreRepository;
import com.mycy.repository.MovieCinemaRepository;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class Consume_WebClient {

    private final WebClient webClient = WebClient.builder().baseUrl("http://localhost:8080").build();
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

    /**
     * Consuming a URL using Webclient
     * @return fluxes of MovieCinema
     */
    @GetMapping("/flux")
    public Flux<MovieCinema> readWithWebClient(){
        return webClient
                .get()
                .uri("/flux-movie-cinema")
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .retrieve()
                .bodyToFlux(MovieCinema.class);
    }

    /**
     * Consumes a URL to retrieve Mono result
     * @param id Long
     * @return MovieCinema
     */
    @GetMapping("/mono/{id}")
    public Mono<MovieCinema> readMonoWithWebClient(@PathVariable("id") Long id){
        return webClient
                .get()
                .uri("/mono-movie-cinema/{id}",id)
                .retrieve()
                .bodyToMono(MovieCinema.class);
    }
}
