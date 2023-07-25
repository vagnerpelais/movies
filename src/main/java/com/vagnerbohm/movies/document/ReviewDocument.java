package com.vagnerbohm.movies.document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection = "reviews")
public class ReviewDocument {
    @Id
    private ObjectId id;
    private String body;

    public ReviewDocument(String body) {
        this.body = body;
    }
}
