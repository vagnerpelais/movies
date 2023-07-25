package com.vagnerbohm.movies.service;

import com.vagnerbohm.movies.document.MovieDocument;
import com.vagnerbohm.movies.document.ReviewDocument;
import com.vagnerbohm.movies.dto.ReviewDTO;
import com.vagnerbohm.movies.dto.mapper.ReviewDTOMapper;
import com.vagnerbohm.movies.repository.MovieRepository;
import com.vagnerbohm.movies.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
@Slf4j
public class ReviewService {
    private final ReviewRepository reviewRepository;
    private final MovieRepository movieRepository;
    private final MongoTemplate mongoTemplate;

    public ReviewDTO createReview(String reviewBody, String imdbId) {
        if(this.movieRepository.existsMovieByImdbId(imdbId)) {
            ReviewDocument reviewDocument = this.reviewRepository.insert(new ReviewDocument(reviewBody));

            this.mongoTemplate.update(MovieDocument.class)
                    .matching(Criteria.where("imdbId").is(imdbId))
                    .apply(new Update().push("reviewIds").value(reviewDocument))
                    .first();

            return ReviewDTOMapper.fromReviewDocument(reviewDocument);
        } else {
            log.info("The imdbId does not exist: {}", imdbId);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "movie not found by imdbId: " + imdbId);
        }
    }
}
