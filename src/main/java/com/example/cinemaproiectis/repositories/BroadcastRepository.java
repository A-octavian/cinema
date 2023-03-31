package com.example.cinemaproiectis.repositories;

import com.example.cinemaproiectis.models.Broadcast;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BroadcastRepository extends JpaRepository<Broadcast, Long> {
}
