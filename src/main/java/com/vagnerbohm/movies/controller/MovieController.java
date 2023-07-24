package com.vagnerbohm.movies.controller;

import com.vagnerbohm.movies.document.HttpResponse;
import com.vagnerbohm.movies.dto.MovieDTO;
import com.vagnerbohm.movies.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Map;

import static java.time.LocalDateTime.now;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/movies")
public class MovieController {
    private final MovieService movieService;

    @GetMapping
    public ResponseEntity<HttpResponse> getAllMovies()  {
        return ResponseEntity.ok().body(
                HttpResponse.builder()
                        .timeStamp(now().toString())
                        .data(Map.of("movies", this.movieService.getAllMovies()))
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<HttpResponse> getMovieById(@PathVariable String id)  {
        return ResponseEntity.ok().body(
                HttpResponse.builder()
                        .timeStamp(now().toString())
                        .data(Map.of("movie", this.movieService.getMovieById(id)))
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build()
        );
    }

    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<HttpResponse> handleResponseStatusException(ResponseStatusException e) {
        HttpStatus status = (HttpStatus) e.getStatusCode();

        return ResponseEntity.status(e.getStatusCode()).body(
                HttpResponse.builder()
                        .timeStamp(now().toString())
                        .message(e.getReason())
                        .status(status)
                        .statusCode(e.getStatusCode().value())
                        .build()
        );
    }
}
