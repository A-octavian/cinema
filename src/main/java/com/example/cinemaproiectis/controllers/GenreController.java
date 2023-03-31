package com.example.cinemaproiectis.controllers;

import com.example.cinemaproiectis.models.Genre;
import com.example.cinemaproiectis.services.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GenreController {
    private final GenreService genreService;

    @Autowired
    public GenreController(GenreService genreService) {
        this.genreService = genreService;
    }

    @GetMapping("/genre")
    public List<Genre> getGenres() {
        return genreService.getGenres();
    }

    @PostMapping("/genre")
    public void addNewGenre(@RequestBody Genre genre) {
        genreService.addNewGenre(genre);
    }

    @DeleteMapping(path = "/genre/{genreId}")
    public void deleteGenre(@PathVariable("genreId") Long genreId) {
        genreService.deleteGenre(genreId);
    }

    @PutMapping(path = "/genre/{genreId}")
    public void updateGenre(
            @PathVariable("genreId") Long genreId,
            @RequestParam(required = false) String name) {
        genreService.updateGenre(genreId, name);
    }
}

