package com.vagnerbohm.movies.service;

import com.vagnerbohm.movies.document.MovieDocument;
import com.vagnerbohm.movies.dto.MovieDTO;
import com.vagnerbohm.movies.dto.mapper.MovieDTOMapper;
import com.vagnerbohm.movies.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieService {
    private final MovieRepository movieRepository;

    public List<MovieDTO> getALlMovies() {
        return MovieDTOMapper.allFromMovieDocument(this.movieRepository.findAll());
    }
}
