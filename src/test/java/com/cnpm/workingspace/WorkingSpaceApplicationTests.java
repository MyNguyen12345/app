package com.cnpm.workingspace;

import com.cnpm.workingspace.model.Review;
import com.cnpm.workingspace.repository.ReviewRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.*;
import java.util.List;

@SpringBootTest
class WorkingSpaceApplicationTests {

    @Autowired
    ReviewRepository reviewRepository;
    @Test
    public void test() {
        List<Review> reviews = reviewRepository.getByPropertyPropertyId(1);
        assertThat(reviews.get(0).getReviewId()).isNotNull();
    }
}
