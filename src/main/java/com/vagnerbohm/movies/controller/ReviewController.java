package com.vagnerbohm.movies.controller;

import com.vagnerbohm.movies.document.HttpResponse;
import com.vagnerbohm.movies.dto.ReviewRequestBodyDTO;
import com.vagnerbohm.movies.service.ReviewService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Map;

import static java.time.LocalDateTime.now;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/reviews")
public class ReviewController {
    private final ReviewService reviewService;

    @PostMapping
    public ResponseEntity<HttpResponse> createReview(@RequestBody @Valid ReviewRequestBodyDTO payload) {
        return ResponseEntity.created(getUri(payload.getImdbId())).body(
                HttpResponse.builder()
                        .timeStamp(now().toString())
                        .data(Map.of("review", this.reviewService.createReview(
                                payload.getReviewBody(),
                                payload.getImdbId())))
                        .message("Review created")
                        .status(HttpStatus.CREATED)
                        .statusCode(HttpStatus.CREATED.value())
                        .build()
        );
    }

    private URI getUri(String imdbId) {
        return URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/v1/movies/" + imdbId).toUriString());
    }


}
