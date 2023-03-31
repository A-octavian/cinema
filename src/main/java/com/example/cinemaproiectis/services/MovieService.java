package com.example.cinemaproiectis.services;

import com.example.cinemaproiectis.models.Genre;
import com.example.cinemaproiectis.models.Movie;
import com.example.cinemaproiectis.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class MovieService {
    private final MovieRepository movieRepository;

    @Autowired
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> getMovies() {
        return movieRepository.findAll();
    }

    public void addNewMovie(Movie movie) {
        Optional<Movie> movieOptional = movieRepository.findMovieByName(movie.getName());
        if (movieOptional.isPresent()) {
            throw new IllegalStateException("Movie with name" + movie.getName() + "already exists");
        }
        movieRepository.save(movie);
    }

    public void deleteMovie(Long movieId) {
        boolean exists = movieRepository.existsById(movieId);
        if (!exists) {
            throw new IllegalStateException("Movie with id" + movieId + "does not exist");
        }
        movieRepository.deleteById(movieId);
    }

    @Transactional
    public void updateMovie(Long movieId,
                            String name,
                            String description,
                            String image,
                            Long userId,
                            Long genreId) {
        Movie movie = movieRepository.findById(movieId).orElseThrow(()
                -> new IllegalStateException("movie with id " + movieId + " does not exist"));
        if (name != null &&
                name.length() > 0 &&
                !Objects.equals(movie.getName(), name)) {
            movie.setName(name);
        }
        if (description != null &&
                description.length() > 0 &&
                !Objects.equals(movie.getDescription(), description)) {
            movie.setDescription(description);
        }
        if (image != null &&
                image.length() > 0 &&
                !Objects.equals(movie.getImage(), image)) {
            movie.setImage(image);
        }
        if (userId != null &&
                !Objects.equals(movie.getUser().getId(), userId)) {
            movie.getUser().setId(userId);
        }
        if (genreId != null &&
                !Objects.equals(movie.getUser().getId(), genreId)) {
            movie.getGenre().setId(genreId);
        }
    }
}

