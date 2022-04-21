package com.cnpm.workingspace.controller;

import com.cnpm.workingspace.constants.ErrorCode;
import com.cnpm.workingspace.dto.ReviewDto;
import com.cnpm.workingspace.model.Review;
import com.cnpm.workingspace.security.response.ErrorResponse;
import com.cnpm.workingspace.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ReviewController {

    @Autowired
    ReviewService reviewService;

    @GetMapping("/properties/{propertyId}/reviews")
    public ResponseEntity<?> getReviewsByPropertyId(@PathVariable int propertyId) {
        List<ReviewDto> reviews = reviewService.getReviewByPropertyId(propertyId);
        return new ResponseEntity<>(new ErrorResponse(ErrorCode.SUCCESS, reviews), HttpStatus.OK);
    }
}
