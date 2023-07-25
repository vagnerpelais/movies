package com.vagnerbohm.movies.repository;

import com.vagnerbohm.movies.document.ReviewDocument;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends MongoRepository<ReviewDocument, ObjectId> {
}
