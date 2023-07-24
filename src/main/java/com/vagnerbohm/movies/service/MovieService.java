package com.vagnerbohm.movies.service;

import com.vagnerbohm.movies.document.MovieDocument;
import com.vagnerbohm.movies.dto.MovieDTO;
import com.vagnerbohm.movies.dto.mapper.MovieDTOMapper;
import com.vagnerbohm.movies.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieService {
    private final MovieRepository movieRepository;

    public List<MovieDTO> getAllMovies() {
        return MovieDTOMapper.allFromMovieDocument(this.movieRepository.findAll());
    }

    public MovieDTO getMovieById(String id) {
        if(!this.movieRepository.existsMovieByImdbId(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "movie not found by id: " + id);
        }
        return MovieDTOMapper.fromMovieDocument(this.movieRepository.findMovieByImdbId(id).get());
    }
}
