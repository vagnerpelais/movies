package com.vagnerbohm.movies.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ReviewRequestBodyDTO {
    @NotBlank
    private String reviewBody;
    @NotBlank
    private String imdbId;
}
