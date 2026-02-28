package com.capgemini.moviemanagementsystem.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

@Entity
@Table(name = "movie")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String genre;

    @Column(nullable = false)
    private String director;

    @Column(nullable = false)
    private Integer releaseyear;

    @Column(nullable = false)
    @Min(value = 0, message = "Rating must be atleast 0")
    @Max(value = 10, message = "Rating must be less than 10")
    private Double rating;

    public Movie() {
    }

	public Movie(Integer id, String title, String genre, String director, Integer releaseyear,
			@Min(value = 0, message = "Rating must be atleast 0") @Max(value = 10, message = "Rating must be less than 10") Double rating) {
		super();
		this.id = id;
		this.title = title;
		this.genre = genre;
		this.director = director;
		this.releaseyear = releaseyear;
		this.rating = rating;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public Integer getReleaseyear() {
		return releaseyear;
	}

	public void setReleaseyear(Integer releaseyear) {
		this.releaseyear = releaseyear;
	}

	public Double getRating() {
		return rating;
	}

	public void setRating(Double rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "Movie [id=" + id + ", title=" + title + ", genre=" + genre + ", director=" + director + ", releaseyear="
				+ releaseyear + ", rating=" + rating + "]";
	}
}

    // Getters & Setters