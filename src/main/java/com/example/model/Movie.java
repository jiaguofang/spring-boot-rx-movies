package com.example.model;

import com.example.service.response.Rating;
import com.example.service.response.Review;

import java.util.List;

/**
 * @author Jiaguo Fang
 */
public class Movie {
    
    private String id;
    
    private String title;
    
    private String year;
    
    private Rating rating;
    
    private List<Review> reviews;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", year='" + year + '\'' +
                ", rating=" + rating +
                ", reviews=" + reviews +
                '}';
    }
}
