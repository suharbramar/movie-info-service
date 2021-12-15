package io.bramcode.movie.movieinfoservices.service;

import io.bramcode.movie.movieinfoservices.adaptor.MovieCategoryAdaptor;
import io.bramcode.movie.movieinfoservices.model.CategoryResponse;
import io.bramcode.movie.movieinfoservices.model.entity.Movie;
import io.bramcode.movie.movieinfoservices.model.MovieResponse;
import io.bramcode.movie.movieinfoservices.repository.MovieRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.*;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    MovieCategoryAdaptor movieCategoryAdaptor;

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

    public MovieResponse retreiveById(Long movieId) throws NotFoundException {
         Optional<Movie> dataMovie = movieRepository.findById(movieId);

         var movie= dataMovie.map(value -> {
                      MovieResponse movieResponse = new MovieResponse();
                      movieResponse.setMovieId(value.getMovieId());
                      movieResponse.setMovieName(value.getMovieName());
                      movieResponse.setMovieDescription(value.getMovieDescription());
                      movieResponse.setIsActive(value.getIsActive());
                      movieResponse.setCreateDate(value.getCreateDate());
                      movieResponse.setRating(value.getRating());

                      return movieResponse;
                 }

         ).orElseThrow(() -> new NotFoundException(movieId +"Not Found"));

        return movie;
    }

    public Movie updateMovie(Long movieId, Movie movie){

        Optional<Movie> optMovie = movieRepository.findById(movieId);

        if(isCategoryExist(movie.getCategoryId()) && optMovie.isPresent()){
            Movie updMovie = optMovie.get();
            updMovie.setMovieName(movie.getMovieName());
            updMovie.setMovieDescription(movie.getMovieDescription());
            updMovie.setIsActive(movie.getIsActive());
            updMovie.setRating(movie.getRating());
            updMovie.setUpdateBy("SYSTEM");
            updMovie.setUpdateDate(new Timestamp(System.currentTimeMillis()));

            movieRepository.save(updMovie);

            return updMovie;

        }else{
            ResponseEntity.notFound();
        }

        return movie;

    }

    public Map<String, Boolean> deleteMovie(Long movieId){
        Optional<Movie> optMovie = movieRepository.findById(movieId);

        Map<String, Boolean> response = new HashMap<>();
        if(optMovie.isPresent()){
            Movie delMovie = optMovie.get();
            movieRepository.delete(delMovie);

            response.put("Deleted", Boolean.TRUE);

        }else{
            ResponseEntity.notFound();
        }

        return response;
    }


}
