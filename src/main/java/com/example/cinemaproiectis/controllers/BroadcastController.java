package com.example.cinemaproiectis.controllers;

import com.example.cinemaproiectis.models.Broadcast;
import com.example.cinemaproiectis.services.BroadcastService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class BroadcastController {
    private final BroadcastService broadcastService;

    @Autowired
    public BroadcastController(BroadcastService broadcastService){
        this.broadcastService = broadcastService;
    }

    @GetMapping("/broadcast")
    public List<Broadcast> getBroadcasts(){
        return broadcastService.getBroadcasts();
    }

    @PostMapping("/broadcast")
    public void addNewBroadcast(@RequestBody Broadcast broadcast){
        broadcastService.addNewBroadcast(broadcast);
    }

    @DeleteMapping(path = "broadcast/{broadcastId}")
    public void deleteBroadcast(@PathVariable("broadcastId") Long broadcastId){
        broadcastService.deleteBroadcast(broadcastId);
    }

    @PutMapping( path = "broadcast/{broadcastId}")
    public void updateBroadcast(
            @PathVariable("broadcastId") Long broadcastId,
            @RequestParam(required = false) Long movieId,
            @RequestParam(required = false) Long roomId,
            @RequestParam(required = false) Date date) {
        broadcastService.updateBroadcast(broadcastId,movieId,roomId,date);
    }
}
