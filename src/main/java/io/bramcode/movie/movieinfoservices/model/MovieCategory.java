package io.bramcode.movie.movieinfoservices.model;

import io.bramcode.movie.movieinfoservices.model.entity.Movie;

import java.util.List;

public class MovieCategory {
    private Long categoryId;
    private List<Movie> movies;

    public MovieCategory() {
    }

    public MovieCategory(Long categoryId, List<Movie> movies) {
        this.categoryId = categoryId;
        this.movies = movies;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public MovieCategory setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
        return this;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public MovieCategory setMovies(List<Movie> movies) {
        this.movies = movies;
        return this;
    }
}
