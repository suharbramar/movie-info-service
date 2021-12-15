package io.bramcode.movie.movieinfoservices.service;

import io.bramcode.movie.movieinfoservices.adaptor.MovieCategoryAdaptor;
import io.bramcode.movie.movieinfoservices.adaptor.MovieRatingAdaptor;
import io.bramcode.movie.movieinfoservices.model.*;
import io.bramcode.movie.movieinfoservices.model.entity.Movie;
import io.bramcode.movie.movieinfoservices.repository.MovieRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MovieRatingService {

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    MovieCategoryAdaptor movieCategoryAdaptor;

    @Autowired
    MovieRatingAdaptor movieRatingAdaptor;

    @Autowired
    MovieService movieService;

    public boolean isCategoryExist(Long categoryId){
        CategoryResponse categoryResponse = movieCategoryAdaptor.getCategoryById(String.valueOf(categoryId));

        return (Objects.nonNull(categoryResponse) && Boolean.TRUE.equals(categoryResponse.getIsActive()));

    }
    public Movie execute(Movie movie){
        Long categoryId = movie.getCategoryId();

        if(isCategoryExist(categoryId)){
            return movieRepository.save(movie);
        }
            return (Movie) ResponseEntity.notFound();
    }

    public List<Movie> retreiveAll(){
          return movieRepository.findAll();
    }


    public MovieRating getMovieRating(Long movieId) throws NotFoundException {

        MovieResponse movieResponse = movieService.retreiveById(movieId);
        RatingInfo ratingInfo = movieRatingAdaptor.getMovieRating(String.valueOf(movieResponse.getMovieId()));

        MovieRating movieRating = new MovieRating();
        movieRating.setMovieId(movieResponse.getMovieId());
        movieRating.setMovieName(movieResponse.getMovieName());
        movieRating.setMovieDescription(movieResponse.getMovieDescription());
        movieRating.setRating(movieResponse.getRating());
        movieRating.setIsActive(movieResponse.getIsActive());
        movieRating.setMovieReleaseDate(movieResponse.getCreateDate());
        movieRating.setUserRatingCommentList(ratingInfo.getUserRatingCommentList());

        return movieRating;

    }

}
