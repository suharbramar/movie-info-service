package io.bramcode.movie.movieinfoservices.controller;

import io.bramcode.movie.movieinfoservices.model.MovieCategory;
import io.bramcode.movie.movieinfoservices.model.MovieRating;
import io.bramcode.movie.movieinfoservices.model.MovieResponse;
import io.bramcode.movie.movieinfoservices.service.MovieCategoryService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/movie/list")
public class MovieCategoryResource {

    @Autowired
    MovieCategoryService movieCategoryService;


    @GetMapping("/category/{categoryId}")
    public MovieCategory getMovieByCategoryId(@PathVariable(value = "categoryId") Long categoryId) throws NotFoundException {
        return movieCategoryService.retreiveMovieByCategoryId(categoryId);
    }


}
