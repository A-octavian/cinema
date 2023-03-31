package com.example.cinemaproiectis.repositories;

import com.example.cinemaproiectis.models.Category;
import com.example.cinemaproiectis.models.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GenreRepository extends JpaRepository<Genre,Long> {
    @Query("Select g from Genre g where g.name = ?1")
    Optional<Genre> findGenreByName(String name);
}
