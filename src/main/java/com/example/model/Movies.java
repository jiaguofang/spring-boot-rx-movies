package com.example.model;

import java.util.List;

/**
 * @author Jiaguo Fang
 */
public class Movies {
    
    private List<Movie> movies;

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    @Override
    public String toString() {
        return "Movies{" +
                "movies=" + movies +
                '}';
    }
}
