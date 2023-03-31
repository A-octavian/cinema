package com.example.cinemaproiectis.repositories;

import com.example.cinemaproiectis.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MovieRepository extends JpaRepository<Movie,Long> {
    @Query ("Select m from Movie m where m.name = ?1")
    Optional<Movie> findMovieByName(String name);
}
