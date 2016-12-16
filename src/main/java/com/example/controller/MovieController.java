package com.example.controller;

import com.example.model.Movies;
import com.example.service.api.MovieService;
import com.example.service.api.RatingService;
import com.example.service.api.ReviewService;
import com.example.service.api.UserMovieService;
import com.example.service.response.Rating;
import com.example.service.response.Review;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;
import rx.Observable;
import rx.schedulers.Schedulers;

import java.util.List;
import java.util.concurrent.ExecutorService;

/**
 * @author Jiaguo Fang
 */
@RestController
public class MovieController {

    @Autowired
    private UserMovieService userMovieService;

    @Autowired
    private MovieService movieService;

    @Autowired
    private RatingService ratingService;

    @Autowired
    private ReviewService reviewService;

    @Autowired
    private ExecutorService executorService;

    private static Logger logger = LoggerFactory.getLogger(MovieController.class);

    @RequestMapping(value = "/movies/{userId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public DeferredResult getMoviesByUserId(@PathVariable String userId) {
        logger.info("Start calling MovieController::getMoviesByUserId");

        DeferredResult<Movies> deferredResult = new DeferredResult<>();
        userMovieService.getUserMovie(userId)
                .flatMap(movieId -> movieService.getMovie(movieId)
                        .subscribeOn(Schedulers.from(executorService)))
                .flatMap(movie -> {
                    Observable<Rating> observable1 = ratingService.getRating(movie.getRatingId())
                            .subscribeOn(Schedulers.from(executorService));
                    Observable<List<Review>> observable2 = Observable.from(movie.getReviewIds())
                            .flatMap(reviewId -> reviewService.getReview(reviewId)
                                    .subscribeOn(Schedulers.from(executorService)))
                            .toList();

                    return Observable.zip(observable1, observable2, (rating, reviews) -> {
                        com.example.model.Movie m = new com.example.model.Movie();
                        m.setId(movie.getId());
                        m.setTitle(movie.getTitle());
                        m.setYear(movie.getYear());
                        m.setRating(rating);
                        m.setReviews(reviews);
                        return m;
                    });
                })
                .toList()
                .subscribeOn(Schedulers.from(executorService))
                .subscribe(listOfMovies -> {
                    logger.info("Inside Observable::subscribe");
                    
                    Movies movies = new Movies();
                    movies.setMovies(listOfMovies);
                    deferredResult.setResult(movies);
                }, deferredResult::setErrorResult);

        logger.info("End calling MovieController::getMoviesByUserId");
        return deferredResult;
    }
}
