package com.framgia.moviedb.data.source.remote.api.service;

import com.framgia.moviedb.data.model.GenreResponse;
import com.framgia.moviedb.data.model.Movie;
import com.framgia.moviedb.data.model.MovieResponse;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by workspace on 22/09/2017.
 */

public interface MovieApi {
    @GET("movie/popular")
    Observable<MovieResponse> getMoviePopularResponse(@Query("api_key") String apiKey);

    @GET("movie/top_rated")
    Observable<MovieResponse> getMovieTopRatedResponse(@Query("api_key") String apiKey);

    @GET("movie/upcoming")
    Observable<MovieResponse> getMovieUpComingResponse(@Query("api_key") String apiKey);

    @GET("movie/now_playing")
    Observable<MovieResponse> getMovieNowPlayingResponse(@Query("api_key") String apiKey);

    @GET("movie/{movie_id}")
    Observable<Movie> getDetail(@Path("id") String id, @Query("api_key") String apiKey);

    @GET("genre/movie/list")
    Observable<GenreResponse> getGenres(@Query("api_key") String apiKey);
}