package com.cnpm.workingspace.service;

import com.cnpm.workingspace.dto.ReviewDto;
import com.cnpm.workingspace.model.Review;

import java.util.List;

public interface ReviewService {
    List<ReviewDto> getReviewByPropertyId(int propertyId);
}
