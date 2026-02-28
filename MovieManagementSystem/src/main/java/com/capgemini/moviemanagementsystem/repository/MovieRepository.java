package com.capgemini.moviemanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.moviemanagementsystem.Model.Movie;
@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer>{

}
