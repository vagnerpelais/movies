package com.vagnerbohm.movies.dto;

import com.vagnerbohm.movies.document.ReviewDocument;
import lombok.Data;


import java.util.List;

@Data
public class MovieDTO {
    private String imdbId;
    private String title;
    private String releaseDate;
    private String trailerLink;
    private String poster;
    private List<String> genres;
    private List<String> backdrops;
    private List<ReviewDocument> reviewIds;
}
