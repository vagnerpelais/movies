package com.vagnerbohm.movies.service;

import com.vagnerbohm.movies.dto.MovieDTO;
import com.vagnerbohm.movies.dto.mapper.MovieDTOMapper;
import com.vagnerbohm.movies.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class MovieService {
    private final MovieRepository movieRepository;

    public List<MovieDTO> getAllMovies() {
        return MovieDTOMapper.allFromMovieDocument(this.movieRepository.findAll());
    }

    public MovieDTO getMovieById(String id) {
        if(!this.movieRepository.existsMovieByImdbId(id)) {
            log.info("A movie with the imdbId provided was not found: {}", id);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "movie not found by id: " + id);
        }
        return MovieDTOMapper.fromMovieDocument(this.movieRepository.findMovieByImdbId(id).get());
    }
}
