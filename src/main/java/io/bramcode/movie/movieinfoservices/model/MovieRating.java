package io.bramcode.movie.movieinfoservices.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;


public class MovieRating {

    private Long movieId;
    private String movieName;
    private String movieDescription;
    private BigDecimal rating;
    private Boolean isActive;
    private Timestamp movieReleaseDate;
    private List<UserRatingComment> userRatingCommentList;

    public MovieRating(){}

    public MovieRating(Long movieId, String movieName, String movieDescription, BigDecimal rating,
                       Boolean isActive, Timestamp movieReleaseDate, List<UserRatingComment> userRatingCommentList) {
        this.movieId = movieId;
        this.movieName = movieName;
        this.movieDescription = movieDescription;
        this.rating = rating;
        this.isActive = isActive;
        this.movieReleaseDate = movieReleaseDate;
        this.userRatingCommentList = userRatingCommentList;
    }

    public Long getMovieId() {
        return movieId;
    }

    public MovieRating setMovieId(Long movieId) {
        this.movieId = movieId;
        return this;
    }

    public String getMovieName() {
        return movieName;
    }

    public MovieRating setMovieName(String movieName) {
        this.movieName = movieName;
        return this;
    }

    public String getMovieDescription() {
        return movieDescription;
    }

    public MovieRating setMovieDescription(String movieDescription) {
        this.movieDescription = movieDescription;
        return this;
    }

    public BigDecimal getRating() {
        return rating;
    }

    public MovieRating setRating(BigDecimal rating) {
        this.rating = rating;
        return this;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public MovieRating setIsActive(Boolean active) {
        isActive = active;
        return this;
    }

    public List<UserRatingComment> getUserRatingCommentList() {
        return userRatingCommentList;
    }

    public MovieRating setUserRatingCommentList(List<UserRatingComment> userRatingCommentList) {
        this.userRatingCommentList = userRatingCommentList;
        return this;
    }

    public Timestamp getMovieReleaseDate() {
        return movieReleaseDate;
    }

    public MovieRating setMovieReleaseDate(Timestamp movieReleaseDate) {
        this.movieReleaseDate = movieReleaseDate;
        return this;
    }
}
