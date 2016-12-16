package com.example.service.response;

import java.util.List;

/**
 * @author Jiaguo Fang
 */
public class Movie {
    
    private String id;
    
    private String title;
    
    private String year;
    
    private String ratingId;
    
    private List<String> reviewIds;

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

    public String getRatingId() {
        return ratingId;
    }

    public void setRatingId(String ratingId) {
        this.ratingId = ratingId;
    }

    public List<String> getReviewIds() {
        return reviewIds;
    }

    public void setReviewIds(List<String> reviewIds) {
        this.reviewIds = reviewIds;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", year='" + year + '\'' +
                ", ratingId='" + ratingId + '\'' +
                ", reviewIds=" + reviewIds +
                '}';
    }
}
