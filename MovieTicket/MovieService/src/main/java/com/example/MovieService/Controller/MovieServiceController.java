package com.example.MovieService.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.MovieService.Model.Movie;



@RestController
@RequestMapping("/movies")
public class MovieServiceController {

    private List<Movie> movies = List.of(
            new Movie(1,"Inception","English",250),
            new Movie(2,"Interstellar","English",300)
    );

    @GetMapping
    public List<Movie> getMovies() {
        return movies;
    }

    @GetMapping("/{id}")
    public Movie getMovie(@PathVariable int id) {

        return movies.stream()
                .filter(m -> m.getId()==id)
                .findFirst()
                .orElse(null);
    }
}
