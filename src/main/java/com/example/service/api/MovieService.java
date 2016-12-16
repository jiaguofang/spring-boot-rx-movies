package com.example.service.api;

import com.example.service.response.Movie;
import rx.Observable;

/**
 * @author Jiaguo Fang
 */
public interface MovieService {

    Observable<Movie> getMovie(String movieId);
}
