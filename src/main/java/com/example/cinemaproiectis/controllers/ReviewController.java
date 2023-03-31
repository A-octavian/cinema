package com.example.cinemaproiectis.controllers;

import com.example.cinemaproiectis.models.Review;
import com.example.cinemaproiectis.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReviewController {
    private final ReviewService reviewService;

    @Autowired
    public ReviewController(ReviewService reviewService){
        this.reviewService = reviewService;
    }

    @GetMapping("/review")
    public List<Review> getReviews(){
        return reviewService.getReviews();
    }

    @DeleteMapping (path = "/review/{reviewId}")
    public void deleteReview(@PathVariable("reviewId") Long reviewId){
        reviewService.deleteReview(reviewId);
    }

    @PostMapping("/review")
    public void addNewReview(@RequestBody Review review){
        reviewService.addNewReview(review);
    }
}
