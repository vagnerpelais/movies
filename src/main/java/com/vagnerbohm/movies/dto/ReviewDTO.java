package com.vagnerbohm.movies.dto;

import lombok.Data;
import org.bson.types.ObjectId;

@Data
public class ReviewDTO {
    private ObjectId id;
    private String body;
}
