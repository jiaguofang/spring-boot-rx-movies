package com.example.service.api;

import rx.Observable;

/**
 * @author Jiaguo Fang
 */
public interface UserMovieService {

    Observable<String> getUserMovie(String userId);
}
