package com.example.youthcon;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ReviewServiceTest {

    ReviewRepository reviewRepository;
    ReviewService reviewService = new ReviewService();

    @Test
    void 후기_조회_성공() {
        // 준비

        // 실행
        Review review = reviewService.getById(1L);

        // 검증
        assertThat(review.getId()).isEqualTo(1);
    }

}