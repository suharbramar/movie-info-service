package io.bramcode.movie.movieinfoservices.service;

import io.bramcode.movie.movieinfoservices.model.MovieCategory;
import io.bramcode.movie.movieinfoservices.model.entity.Movie;
import io.bramcode.movie.movieinfoservices.repository.MovieRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieCategoryService {

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    MovieRatingService movieRatingService;

    @Autowired
    MovieService movieService;

    public MovieCategory retreiveMovieByCategoryId(Long categoryId) throws NotFoundException {
        List<Movie> dataMovie = movieRepository.findByCategoryId(categoryId);
        MovieCategory movieCategory = new MovieCategory();

        movieCategory.setCategoryId(categoryId);
        movieCategory.setMovies(dataMovie);

        return movieCategory;
    }
}
