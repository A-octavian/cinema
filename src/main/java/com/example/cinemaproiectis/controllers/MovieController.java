package com.example.cinemaproiectis.controllers;

import com.example.cinemaproiectis.models.Movie;
import com.example.cinemaproiectis.services.MovieService;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovieController {
    private final MovieService movieService;

    @Autowired
    public MovieController (MovieService movieService){
        this.movieService = movieService;
    }

    @GetMapping("/movie")
    public List<Movie> getMovies(){
        return movieService.getMovies();
    }
//    public JSONObject getMovies(){
//        return JSONObject()
//    }
//    @GetMapping()
//    //obiect dto ->
//    public ResponseEntity<List<CredentialDTO>> getCredentials() {
//        List<CredentialDTO> credentialDTOS = credentialService.findCredentials();
//        return new ResponseEntity<>(credentialDTOS, HttpStatus.OK);
   // }


    @PostMapping("/movie")
    public void addNewMovie(@RequestBody Movie movie){
        movieService.addNewMovie(movie);
    }
//    @PostMapping("/movie")
//    public JSONObject add(@RequestBody Movie movie){
//        Movie movie1 = new Movie();
//        return new JSONObject("mv"  movie1);
//    }

    @DeleteMapping(path = "movie/{movieId}")
    public void deleteMovie(@PathVariable("movieId") Long movieId){
        movieService.deleteMovie(movieId);
    }
    @PutMapping( path = "movie/{movieId}")
    public void updateMovie(
            @PathVariable("movieId") Long movieId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String description,
            @RequestParam(required = false) String image,
            @RequestParam(required = false) Long userId,
            @RequestParam(required = false) Long genreId
            ){
        movieService.updateMovie(movieId,name,description,image,userId,genreId);
    }
}
