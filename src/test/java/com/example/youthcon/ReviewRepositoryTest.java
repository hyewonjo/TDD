package com.example.youthcon;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
// @DataJpaTest 어노테이션은 JPA 관련 테스트 설정만 로드합니다.
class ReviewRepositoryTest {

    @Autowired
    ReviewRepository reviewRepository;

    @Test
    void 후기_조회_성공() {
        // 준비

        // 실행
        Review review = reviewRepository.findById(1L)
                .orElseThrow(RuntimeException::new);

        // 검증
        Assertions.assertThat(review.getId()).isEqualTo(1L);
        Assertions.assertThat(review.getContent()).isEqualTo("재밌어요");
        Assertions.assertThat(review.getPhoneNumber()).isEqualTo("010-1111-2222");
    }

}