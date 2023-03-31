package com.example.cinemaproiectis.repositories;

import com.example.cinemaproiectis.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    @Query("Select c from Category c where c.name = ?1")
    Optional<Category> findCategoryByName(String name);
}
