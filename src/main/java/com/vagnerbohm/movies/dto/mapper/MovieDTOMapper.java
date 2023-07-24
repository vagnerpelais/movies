package com.vagnerbohm.movies.dto.mapper;

import com.vagnerbohm.movies.document.MovieDocument;
import com.vagnerbohm.movies.dto.MovieDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MovieDTOMapper {
    public static MovieDTO fromMovieDocument(MovieDocument movieDocument) {
        MovieDTO movieDTO = new MovieDTO();
        BeanUtils.copyProperties(movieDocument, movieDTO);


        return movieDTO;
    }

    public static MovieDocument fromMovieDTO(MovieDTO movieDTO) {
        MovieDocument movieDocument = new MovieDocument();
        BeanUtils.copyProperties(movieDTO, movieDocument);


        return movieDocument;
    }

    public static List<MovieDTO> allFromMovieDocument(List<MovieDocument> movieDocuments) {
        List<MovieDTO> movieDTOS = new ArrayList<>();

        for(MovieDocument movieDocument : movieDocuments) {
            MovieDTO movieDTO = new MovieDTO();
            BeanUtils.copyProperties(movieDocument, movieDTO);

            movieDTOS.add(movieDTO);
        }
        return movieDTOS;
    }
}
