package com.cnpm.workingspace.service;

import com.cnpm.workingspace.dto.ReviewDto;
import com.cnpm.workingspace.model.Customer;
import com.cnpm.workingspace.model.Property;
import com.cnpm.workingspace.model.Review;
import com.cnpm.workingspace.repository.CustomerRepository;
import com.cnpm.workingspace.repository.PropertyRepository;
import com.cnpm.workingspace.repository.ReviewRepository;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner.Mode;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReviewServiceImpl implements ReviewService{

    @Autowired
    ReviewRepository reviewRepository;
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    PropertyRepository propertyRepository;


    ModelMapper toEntityMapper;
    ModelMapper toDtoMapper;

    public ReviewServiceImpl(ModelMapper toEntityMapper, ModelMapper toDtoMapper) {
        Converter<Integer, Customer> customerConverter = context -> customerRepository.getById(context.getSource());
        Converter<Integer, Property> propertyConverter = context -> propertyRepository.getById(context.getSource());
        this.toEntityMapper = toEntityMapper;
        this.toEntityMapper.createTypeMap(ReviewDto.class, Review.class)
                           .addMappings(mapper -> mapper.using(customerConverter).map(ReviewDto::getCustomerId, Review::setCustomer))
                           .addMappings(mapper -> mapper.using(propertyConverter).map(ReviewDto::getPropertyId, Review::setProperty));

        this.toDtoMapper = toDtoMapper;
        this.toDtoMapper.createTypeMap(Review.class, ReviewDto.class)
                        .addMappings(mapper -> mapper.map(review -> review.getCustomer().getCustomerId(), ReviewDto::setCustomerId))
                        .addMappings(mapper -> mapper.map(review -> review.getProperty().getPropertyId(), ReviewDto::setPropertyId));
    }

    @Override
    public List<ReviewDto> getReviewByPropertyId(int propertyId) {
        List<Review> reviews = reviewRepository.getByPropertyPropertyId(propertyId);
        return reviews.stream()
                      .map(review -> toDtoMapper.map(review, ReviewDto.class))
                      .collect(Collectors.toList());
    }
}
