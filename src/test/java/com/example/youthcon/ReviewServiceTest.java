package com.example.youthcon;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ReviewServiceTest {

    @Autowired
    ReviewService reviewService;

    @Test
    void 후기_조회_성공() {
        // 준비

        // 실행
        Review review = reviewService.getById(1L);

        // 검증
        assertThat(review.getId()).isEqualTo(1);
    }

}