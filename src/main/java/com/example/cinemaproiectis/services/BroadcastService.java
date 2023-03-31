package com.example.cinemaproiectis.services;

import com.example.cinemaproiectis.models.Broadcast;
import com.example.cinemaproiectis.repositories.BroadcastRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
@Getter
@Setter
public class BroadcastService {
    private final BroadcastRepository broadcastRepository;

    @Autowired
    public BroadcastService (BroadcastRepository broadcastRepository){
        this.broadcastRepository = broadcastRepository;
    }

    public List<Broadcast> getBroadcasts(){
       return broadcastRepository.findAll();
    }

    public void addNewBroadcast(Broadcast broadcast){
        broadcastRepository.save(broadcast);
    }

    public void deleteBroadcast(Long broadcastId){
        boolean exists = broadcastRepository.existsById(broadcastId);
        if(!exists){
            throw new IllegalStateException("Broadcast with id" +
                    broadcastId +"does not exists");
        }
        broadcastRepository.deleteById(broadcastId);
    }

    @Transactional
    public void updateBroadcast(Long broadcastId,
                                Long movieId,
                                Long roomId,
                                Date date){
        Broadcast broadcast = broadcastRepository.findById(broadcastId).orElseThrow(() ->
                new IllegalStateException("Broadcast with id " + broadcastId + " does not exist"));
        if (movieId != null  &&
                !Objects.equals(broadcast.getMovie().getId(), movieId)) {
            broadcast.getMovie().setId(movieId);
        }
        if (roomId != null &&
                !Objects.equals(broadcast.getRoom().getId(), roomId)) {
            broadcast.getRoom().setId(roomId);
        }
        if( date != null &&
                !Objects.equals(broadcast.getDate(),date)){
            broadcast.setDate(date);
        }

    }
}
