package com.example.service.impl;

import com.example.service.api.MovieService;
import com.example.service.response.Movie;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import rx.Observable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Jiaguo Fang
 */
@Service
public class MovieServiceImpl implements MovieService {

    private static Map<String, Movie> movieMap = new HashMap<>();

    static {
        {
            Movie movie = new Movie();
            movie.setId("m1");
            movie.setTitle("The Shawshank Redemption");
            movie.setYear("1994");
            movie.setRatingId("rt1");
            movie.setReviewIds(Arrays.asList("rv1", "rv2"));
            movieMap.put("m1", movie);
        }

        {
            Movie movie = new Movie();
            movie.setId("m2");
            movie.setTitle("The Lord of the Rings: The Return of the King");
            movie.setYear("2003");
            movie.setRatingId("rt2");
            movie.setReviewIds(Arrays.asList("rv3", "rv4"));
            movieMap.put("m2", movie);
        }

        {
            Movie movie = new Movie();
            movie.setId("m3");
            movie.setTitle("The Dark Knight");
            movie.setYear("2008");
            movie.setRatingId("rt3");
            movie.setReviewIds(Arrays.asList("rv5", "rv6"));
            movieMap.put("m3", movie);
        }

        {
            Movie movie = new Movie();
            movie.setId("m4");
            movie.setTitle("Avatar");
            movie.setYear("2009");
            movie.setRatingId("rt4");
            movie.setReviewIds(Arrays.asList("rv7", "rv8"));
            movieMap.put("m4", movie);
        }
    }
    
    private static Logger logger = LoggerFactory.getLogger(MovieServiceImpl.class);

    @Override
    public Observable<Movie> getMovie(String movieId) {
        return Observable.create(subscriber -> {
            try {
                logger.info("Start calling MovieServiceImpl::getMovie");
                Thread.sleep(1000);
                subscriber.onNext(movieMap.get(movieId));
                subscriber.onCompleted();
                logger.info("End calling MovieServiceImpl::getMovie");
            } catch (Exception e) {
                subscriber.onError(e);
            }
        });
    }
}
