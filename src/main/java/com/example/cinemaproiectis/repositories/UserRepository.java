package com.example.cinemaproiectis.repositories;

import com.example.cinemaproiectis.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    @Query("Select u from User u where u.email=?1")
    Optional<User> findUserByEmail(String email);

}
