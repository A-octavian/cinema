package com.example.cinemaproiectis.services;

import com.example.cinemaproiectis.models.Actor;
import com.example.cinemaproiectis.repositories.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ActorService {

    private final ActorRepository actorRepository;

    @Autowired
    public ActorService(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    public List<Actor> getActors(){
        return actorRepository.findAll();
    }

    public void addNewActor( Actor actor ){
        actorRepository.save(actor);
    }

    public void deleteActor(Long actorId){
        boolean exists = actorRepository.existsById(actorId);
        if(!exists){
            throw new IllegalStateException("Actor with id" +
                    actorId +"does not exists");
        }
        actorRepository.deleteById(actorId);
    }

    @Transactional
    public void updateActor(Long actorId,
                              String firstName,
                              String lastName){
        Actor actor = actorRepository.findById(actorId).orElseThrow(() ->
                new IllegalStateException("Actor with id " + actorId + " does not exist"));
        if (firstName != null &&
                firstName.length() > 0 &&
                !Objects.equals(actor.getFirstName(), firstName)) {
            actor.setFirstName(firstName);
        }
        if (lastName != null &&
                lastName.length() > 0 &&
                !Objects.equals(actor.getLastName(), lastName)) {
            actor.setFirstName(lastName);
        }

    }
}
