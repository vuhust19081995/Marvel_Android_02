package com.framgia.moviedb.data.source.remote.api.service;

import com.framgia.moviedb.data.model.MovieResponse;
import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by workspace on 22/09/2017.
 */

public interface MovieApi {
    @GET("movie/popular")
    Observable<MovieResponse> getMoviePopularResponse();
}
