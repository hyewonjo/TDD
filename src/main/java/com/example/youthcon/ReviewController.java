package com.example.youthcon;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReviewController {
    @GetMapping("/reviews/{id}")
    public Object getReview(@PathVariable Long id) {
        return null;
    }
}
