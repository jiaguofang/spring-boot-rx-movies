package com.example.service.api;

import com.example.service.response.Review;
import rx.Observable;

/**
 * @author Jiaguo Fang
 */
public interface ReviewService {

    Observable<Review> getReview(String reviewId);
}
