package com.example.service.impl;

import com.example.service.api.ReviewService;
import com.example.service.response.Review;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import rx.Observable;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jiaguo Fang
 */
@Service
public class ReviewServiceImpl implements ReviewService {

    private static Map<String, Review> reviewMap = new HashMap<>();

    static {
        {
            Review review = new Review();
            review.setId("rv1");
            review.setAuthor("Tim Cox");
            review.setSummary("One of the finest films made in recent years.");
            reviewMap.put("rv1", review);
        }
        {
            Review review = new Review();
            review.setId("rv2");
            review.setAuthor("Dan Grant");
            review.setSummary("Misery and Stand By Me were the best adaptations up until this one, now you can add Shawshank to that list.");
            reviewMap.put("rv2", review);
        }

        {
            Review review = new Review();
            review.setId("rv3");
            review.setAuthor("Theo Robertson");
            review.setSummary("It takes a miracle for me to go the cinema since smoking is banned in cinema chains but Peter Jackson is a miracle worker.");
            reviewMap.put("rv3", review);
        }

        {
            Review review = new Review();
            review.setId("rv4");
            review.setAuthor("Stacey Bullen");
            review.setSummary("How superb 'The Return of the King' is. It is the ultimate fantasy film and a sure bet for all the film awards this year.");
            reviewMap.put("rv4", review);
        }

        {
            Review review = new Review();
            review.setId("rv5");
            review.setAuthor("Can Bolat");
            review.setSummary("This is one of the best I've watched the movie trilogy.");
            reviewMap.put("rv5", review);
        }

        {
            Review review = new Review();
            review.setId("rv6");
            review.setAuthor("Matt Greenwood");
            review.setSummary("A perfectly made movie, with Heath Ledger at his best.");
            reviewMap.put("rv6", review);
        }

        {
            Review review = new Review();
            review.setId("rv7");
            review.setAuthor("Dan Franzen");
            review.setSummary("James Cameron's long-awaited Titanic follow-up is very pretty to look at but suffers from a flimsy plot and astoundingly stupid plot development.");
            reviewMap.put("rv7", review);
        }

        {
            Review review = new Review();
            review.setId("rv8");
            review.setAuthor("Marco Di Giovanni");
            review.setSummary("Unfortunately, I had to watch it in 2D, but even with that, this movie was just brilliant.");
            reviewMap.put("rv8", review);
        }
    }

    private static Logger logger = LoggerFactory.getLogger(ReviewServiceImpl.class);

    @Override
    public Observable<Review> getReview(String reviewId) {
        return Observable.create(subscriber -> {
            try {
                logger.info("Start calling ReviewServiceImpl::getReview");
                Thread.sleep(1000);
                subscriber.onNext(reviewMap.get(reviewId));
                subscriber.onCompleted();
                logger.info("End calling ReviewServiceImpl::getReview");
            } catch (Exception e) {
                subscriber.onError(e);
            }
        });
    }
}
