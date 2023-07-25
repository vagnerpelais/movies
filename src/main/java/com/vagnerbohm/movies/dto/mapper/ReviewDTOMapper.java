package com.vagnerbohm.movies.dto.mapper;

import com.vagnerbohm.movies.document.ReviewDocument;
import com.vagnerbohm.movies.dto.ReviewDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;


@Component
public class ReviewDTOMapper {
    public static ReviewDTO fromReviewDocument(ReviewDocument reviewDocument) {
        ReviewDTO reviewDTO = new ReviewDTO();
        BeanUtils.copyProperties(reviewDocument, reviewDTO);


        return reviewDTO;
    }

}
