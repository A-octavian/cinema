package com.example.cinemaproiectis.repositories;

import com.example.cinemaproiectis.models.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

@Repository
public interface ReviewRepository extends JpaRepository<Review,Long> {
}
