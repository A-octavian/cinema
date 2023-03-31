package com.example.cinemaproiectis.services;

import com.example.cinemaproiectis.models.Category;
import com.example.cinemaproiectis.models.Genre;
import com.example.cinemaproiectis.repositories.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class GenreService {
    private final GenreRepository genreRepository;

    @Autowired
    public GenreService(GenreRepository genreRepository){
        this.genreRepository = genreRepository;
    }

    public List<Genre> getGenres(){
        return genreRepository.findAll();
    }

    public void addNewGenre(Genre genre){
        Optional<Genre> genreOptional = genreRepository.findGenreByName(genre.getName());
        if( genreOptional.isPresent()){
            throw new IllegalStateException("Genre with name" + genre.getName() +"already exists");
        }
        genreRepository.save(genre);
    }

    public void deleteGenre(Long genreId) {
        boolean exists = genreRepository.existsById(genreId);
        if (!exists) {
            throw new IllegalStateException("genre with id" + genreId +
                    "does not exists");
        }
        genreRepository.deleteById(genreId);
    }
    @Transactional
    public void updateGenre(Long genreId, String name){
        Genre genre = genreRepository.findById(genreId).orElseThrow(()
                -> new IllegalStateException("genre with id " + genreId + " does not exist"));
        if(name != null &&
                name.length() > 0 &&
                !Objects.equals(genre.getName(), name)){
            genre.setName(name);
        }
    }
}
