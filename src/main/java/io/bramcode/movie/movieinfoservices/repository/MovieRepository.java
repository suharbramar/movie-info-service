package io.bramcode.movie.movieinfoservices.repository;

import io.bramcode.movie.movieinfoservices.model.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    @Query(value = "SELECT * FROM MOVIE \n" +
            "WHERE CATEGORY_ID = :categoryId \n", nativeQuery = true)
    List<Movie> findByCategoryId(Long categoryId);

}
