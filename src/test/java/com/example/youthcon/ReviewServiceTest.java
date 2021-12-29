package com.example.youthcon;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

class ReviewServiceTest {

    ReviewRepository reviewRepository = mock(ReviewRepository.class);
    ReviewService reviewService = new ReviewService(reviewRepository);

    @Test
    void 후기_조회_성공() {
        // 준비
        given(reviewRepository.findById(1L)).willReturn(Optional.of(new Review(1L, "재밌어요", "010-1111-2222")));

        // 실행
        Review review = reviewService.getById(1L);

        // 검증
        assertThat(review.getId()).isEqualTo(1);
    }

}