package io.bramcode.movie.movieinfoservices.controller;

import io.bramcode.movie.movieinfoservices.model.MovieRating;
import io.bramcode.movie.movieinfoservices.service.MovieRatingService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movie/rating")
public class MovieRatingResource {

    @Autowired
    MovieRatingService movieRatingService;

    @GetMapping("/{movieId}")
    public MovieRating getMovie(@PathVariable(value = "movieId") Long movieId) throws NotFoundException {
        return movieRatingService.getMovieRating(movieId);
    }

}
