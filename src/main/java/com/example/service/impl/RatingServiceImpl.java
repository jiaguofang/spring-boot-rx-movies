package com.example.service.impl;

import com.example.service.api.RatingService;
import com.example.service.response.Rating;
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
public class RatingServiceImpl implements RatingService {

    private static Map<String, Rating> ratingMap = new HashMap<>();

    static {
        {
            Rating rating = new Rating();
            rating.setAverage(9.3);
            rating.setNumRaters(1738986);
            ratingMap.put("rt1", rating);
        }

        {
            Rating rating = new Rating();
            rating.setAverage(8.9);
            rating.setNumRaters(1248775);
            ratingMap.put("rt2", rating);
        }

        {
            Rating rating = new Rating();
            rating.setAverage(9.0);
            rating.setNumRaters(1723350);
            ratingMap.put("rt3", rating);
        }

        {
            Rating rating = new Rating();
            rating.setAverage(7.9);
            rating.setNumRaters(905836);
            ratingMap.put("rt4", rating);
        }
    }

    private static Logger logger = LoggerFactory.getLogger(RatingServiceImpl.class);

    @Override
    public Observable<Rating> getRating(String ratingId) {
        return Observable.create(subscriber -> {
            try {
                logger.info("Start calling RatingServiceImpl::getRating");
                Thread.sleep(1000);
                subscriber.onNext(ratingMap.get(ratingId));
                subscriber.onCompleted();
                logger.info("End calling RatingServiceImpl::getRating");
            } catch (Exception e) {
                subscriber.onError(e);
            }
        });
    }
}
