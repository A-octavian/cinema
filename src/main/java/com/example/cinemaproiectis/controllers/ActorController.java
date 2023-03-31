package com.example.cinemaproiectis.controllers;

import com.example.cinemaproiectis.models.Actor;
import com.example.cinemaproiectis.services.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ActorController {
    private final ActorService actorService;

    @Autowired
    public ActorController( ActorService actorService){
        this.actorService = actorService;
    }

    @GetMapping("/actor")
    public List<Actor> getActors(){
        return actorService.getActors();
    }

    @PostMapping("/actor")
    public void addNewActor(@RequestBody Actor actor){
        actorService.addNewActor(actor);
    }

    @DeleteMapping(path = "actor/{actorId}")
    public void deleteStudent(@PathVariable("actorId") Long actorId){
        actorService.deleteActor(actorId);
    }

    @PutMapping( path = "actor/{actorId}")
    public void updateActor(
            @PathVariable("actorId") Long actorId,
            @RequestParam(required = false) String firstName,
            @RequestParam( required = false ) String lastName){
        actorService.updateActor(actorId,firstName,lastName);
    }
}
