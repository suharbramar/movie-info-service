package io.bramcode.movie.movieinfoservices.model.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity(name = "Movie")
@Table(name = "movie")
public class Movie {


    @Id
    @SequenceGenerator(
            name = "movie_sequence",
            sequenceName = "movie_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "movie_sequence"
    )
    @Column(
            name = "movie_id",
            updatable = false
    )
    private Long movieId;

    @Column(name = "movie_name", length = 50, nullable = false, columnDefinition = "TEXT")
    private String movieName;

    @Column(name = "movie_description", length = 100, nullable = false, columnDefinition = "TEXT")
    private String movieDescription;

    @Column(name = "rating", precision = 2, scale = 1, nullable = false)
    private BigDecimal rating;

    @Type(type = "org.hibernate.type.NumericBooleanType")
    @Column(name = "is_active", nullable = false)
    private Boolean isActive;

    @Column(name = "category_id", nullable = false)
    private Long categoryId;

    @Column(name = "create_date", nullable = false)
    @CreationTimestamp
    private Timestamp createDate;

    @Column(name = "create_by", length = 50, nullable = false)
    private String createBy;

    @Column(name = "update_date", nullable = false)
    @UpdateTimestamp
    private Timestamp updateDate;

    @Column(name = "update_by", length = 50, nullable = false)
    private String updateBy;


    public Movie(){}

    public Movie(Long movieId, String movieName, String description,
                 BigDecimal rating,
                 Boolean isActive,
                 Long categoryId,
                 String createBy,
                 Timestamp createDate, String updateBy, Timestamp updateDate) {
        this.movieId = movieId;
        this.movieName = movieName;
        this.movieDescription = description;
        this.rating = rating;
        this.isActive = isActive;
        this.categoryId = categoryId;
        this.createBy = createBy;
        this.createDate = createDate;
        this.updateBy = updateBy;
        this.updateDate = updateDate;
    }

    public Long getMovieId() {
        return movieId;
    }

    public Movie setMovieId(Long movieId) {
        this.movieId = movieId;
        return this;
    }

    public String getMovieName() {
        return movieName;
    }

    public Movie setMovieName(String movieName) {
        this.movieName = movieName;
        return this;
    }

    public String getMovieDescription() {
        return movieDescription;
    }

    public Movie setMovieDescription(String description) {
        this.movieDescription = description;
        return this;
    }

    public BigDecimal getRating() {
        return rating;
    }

    public Movie setRating(BigDecimal rating) {
        this.rating = rating;
        return this;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public Movie setIsActive(Boolean active) {
        isActive = active;
        return this;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public Movie setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
        return this;
    }

    public String getCreateBy() {
        return createBy;
    }

    public Movie setCreateBy(String createBy) {
        this.createBy = createBy;
        return this;
    }

    public Timestamp getCreateDate() {
        return createDate;
    }

    public Movie setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
        return this;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public Movie setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
        return this;
    }

    public Timestamp getUpdateDate() {
        return updateDate;
    }

    public Movie setUpdateDate(Timestamp updateDate) {
        this.updateDate = updateDate;
        return this;
    }
}
