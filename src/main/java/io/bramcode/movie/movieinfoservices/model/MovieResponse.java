package io.bramcode.movie.movieinfoservices.model;

import java.math.BigDecimal;
import java.sql.Timestamp;


public class MovieResponse {

    private Long movieId;
    private String movieName;
    private String movieDescription;
    private BigDecimal rating;
    private Boolean isActive;
    private Timestamp createDate;
    private Timestamp updateDate;

    public MovieResponse(){}

    public MovieResponse(Long movieId, String movieName, String movieDescription, BigDecimal rating, Boolean isActive, Timestamp createDate, Timestamp updateDate) {
        this.movieId = movieId;
        this.movieName = movieName;
        this.movieDescription = movieDescription;
        this.rating = rating;
        this.isActive = isActive;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }

    public Long getMovieId() {
        return movieId;
    }

    public MovieResponse setMovieId(Long movieId) {
        this.movieId = movieId;
        return this;
    }

    public String getMovieName() {
        return movieName;
    }

    public MovieResponse setMovieName(String movieName) {
        this.movieName = movieName;
        return this;
    }

    public String getMovieDescription() {
        return movieDescription;
    }

    public MovieResponse setMovieDescription(String movieDescription) {
        this.movieDescription = movieDescription;
        return this;
    }

    public BigDecimal getRating() {
        return rating;
    }

    public MovieResponse setRating(BigDecimal rating) {
        this.rating = rating;
        return this;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public MovieResponse setIsActive(Boolean active) {
        isActive = active;
        return this;
    }

    public Timestamp getCreateDate() {
        return createDate;
    }

    public MovieResponse setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
        return this;
    }

    public Timestamp getUpdateDate() {
        return updateDate;
    }

    public MovieResponse setUpdateDate(Timestamp updateDate) {
        this.updateDate = updateDate;
        return this;
    }
}
