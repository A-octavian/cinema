package com.example.cinemaproiectis.services;

import com.example.cinemaproiectis.models.Review;
import com.example.cinemaproiectis.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {
    private ReviewRepository reviewRepository;

    @Autowired
    public ReviewService(ReviewRepository reviewRepository){
        this.reviewRepository = reviewRepository;
    }

    public List<Review> getReviews(){
        return reviewRepository.findAll();
    }

    public void addNewReview(Review review){
        reviewRepository.save(review);
    }

    public void deleteReview(Long reviewId){
        boolean exists = reviewRepository.existsById(reviewId);
        if(!exists){
            throw new IllegalStateException(("Review with id" + reviewId
            + "does not exist"));
        }
        reviewRepository.deleteById(reviewId);
    }
}
