package com.example.youthcon;

import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
public class ReviewControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    private ReviewService reviewService;

    private Long id = 1L;
    private String content = "재밌어요";
    private String phoneNumber = "010-1111-2222";

    @Test
    void 후기_조회_성공() throws Exception {
        // 준비
        BDDMockito.given(reviewService.getById(id))
                .willReturn(new Review(id, content, phoneNumber));

        // 실행
        ResultActions perform = mockMvc.perform(get("/reviews/" + id));

        // 검증
        perform.andExpect(status().isOk())
                .andExpect(jsonPath("id").value(id))
                .andExpect(jsonPath("content").value(content))
                .andExpect(jsonPath("phoneNumber").value(phoneNumber));
    }
}
