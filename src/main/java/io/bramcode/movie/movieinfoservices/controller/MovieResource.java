package io.bramcode.movie.movieinfoservices.controller;

import io.bramcode.movie.movieinfoservices.model.entity.Movie;
import io.bramcode.movie.movieinfoservices.model.MovieResponse;
import io.bramcode.movie.movieinfoservices.service.MovieService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/movie/list")
public class MovieResource {

    @Autowired
    MovieService movieService;

    @PostMapping("/save")
    public Movie createMovie(@Valid @RequestBody Movie movie) {
        return movieService.execute(movie);
    }

    @GetMapping("/all")
    public List<Movie> getAllMovie(){
        return movieService.retreiveAll();
    }

    @GetMapping("/{id}")
    public MovieResponse getMovie(@PathVariable(value = "id") Long movieId) throws NotFoundException {
        return movieService.retreiveById(movieId);
    }

    @PutMapping("/update/{id}")
    public Movie updateMovie(@PathVariable(value = "id") long movieId,
                                   @Valid @RequestBody Movie movieDetails){

        return movieService.updateMovie(movieId, movieDetails);
    }

    @DeleteMapping("/delete/{id}")
    public Map<String, Boolean> deleteMovie(@PathVariable(value = "id") long movieId){
        return movieService.deleteMovie(movieId);
    }

}
