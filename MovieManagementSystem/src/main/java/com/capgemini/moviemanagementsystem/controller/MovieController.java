package com.capgemini.moviemanagementsystem.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.capgemini.moviemanagementsystem.Model.Movie;
import com.capgemini.moviemanagementsystem.service.MovieService;

@Controller
@RequestMapping("/movie")
public class MovieController {

    private final MovieService service;

    public MovieController(MovieService service) {
        this.service = service;
    }

    // Show all movies
    @GetMapping("/all")
    public String getAllMovies(Model model) {
        model.addAttribute("movies", service.getMovies());
        return "movielist";
    }

    // Show Add Form
    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("movie", new Movie());
        return "movie_form";
    }

    // Save Movie
    @PostMapping("/save")
    public String saveMovie(@ModelAttribute Movie movie) {
        service.createMovie(movie);
        return "redirect:/movie/all";
    }

    // 🔥 Edit Movie
    @GetMapping("/edit/{id}")
    public String editMovie(@PathVariable Integer id, Model model) {
        Movie movie = service.getMovies()
                             .stream()
                             .filter(m -> m.getId().equals(id))
                             .findFirst()
                             .orElseThrow(() -> new IllegalArgumentException("Invalid movie id"));
        model.addAttribute("movie", movie);
        return "movie_form";
    }

    // 🔥 Delete Movie
    @GetMapping("/delete/{id}")
    public String deleteMovie(@PathVariable Integer id) {
        service.deleteMovie(id);
        return "redirect:/movie/all";
    }
}