package com.example.service.api;

import com.example.service.response.Rating;
import rx.Observable;

/**
 * @author Jiaguo Fang
 */
public interface RatingService {

    Observable<Rating> getRating(String ratingId);
}
