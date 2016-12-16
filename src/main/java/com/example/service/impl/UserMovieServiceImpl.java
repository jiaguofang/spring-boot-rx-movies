package com.example.service.impl;

import com.example.service.api.UserMovieService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import rx.Observable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Jiaguo Fang
 */
@Service
public class UserMovieServiceImpl implements UserMovieService {

    private static Map<String, List<String>> userMovies = new HashMap<>();

    static {
        userMovies.put("u1", Arrays.asList("m1", "m2"));
        userMovies.put("u2", Arrays.asList("m3", "m4"));
    }

    private static Logger logger = LoggerFactory.getLogger(UserMovieServiceImpl.class);

    @Override
    public Observable<String> getUserMovie(String userId) {
        return Observable.create(subscriber -> {
            try {
                logger.info("Start calling UserMovieServiceImpl::getUserMovie");
                Thread.sleep(1000);
                userMovies.get(userId)
                        .forEach(subscriber::onNext);
                subscriber.onCompleted();
                logger.info("End calling UserMovieServiceImpl::getUserMovie");
            } catch (Exception e) {
                subscriber.onError(e);
            }
        });
    }
}
