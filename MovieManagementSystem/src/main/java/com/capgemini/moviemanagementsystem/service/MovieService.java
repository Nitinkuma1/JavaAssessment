package com.capgemini.moviemanagementsystem.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.capgemini.moviemanagementsystem.Model.Movie;
import com.capgemini.moviemanagementsystem.repository.MovieRepository;

@Service
public class MovieService {

    private final MovieRepository repository;

    public MovieService(MovieRepository repository) {
        this.repository = repository;
    }

    public Movie createMovie(Movie movie) {
        return repository.save(movie);
    }

    public List<Movie> getMovies() {
        return repository.findAll();
    }

    public Movie updateMovie(Integer id, Movie movie) {
        Movie existingmovie = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid movie id: " + id));

        existingmovie.setDirector(movie.getDirector());
        existingmovie.setGenre(movie.getGenre());
        existingmovie.setRating(movie.getRating());
        existingmovie.setTitle(movie.getTitle());
        existingmovie.setReleaseyear(movie.getReleaseyear());

        return repository.save(existingmovie);
    }

    public void deleteMovie(Integer id) {
        repository.deleteById(id);
    }
}
