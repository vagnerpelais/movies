package com.vagnerbohm.movies.repository;

import com.vagnerbohm.movies.document.MovieDocument;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MovieRepository extends MongoRepository<MovieDocument, ObjectId> {
    Optional<MovieDocument> findMovieByImdbId(String imdbId);

    Boolean existsMovieByImdbId(String id);
}
