package com.framgia.moviedb.data.source.remote;

import com.framgia.moviedb.data.model.Movie;
import com.framgia.moviedb.data.model.MovieResponse;
import com.framgia.moviedb.data.source.MovieDataSource;
import com.framgia.moviedb.data.source.remote.api.service.MovieApi;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import java.util.List;

/**
 * Created by workspace on 22/09/2017.
 */

public class MovieRemoteDataSoure extends BaseRemoteDataSoure
        implements MovieDataSource.RemoteDataSource {
    public MovieRemoteDataSoure(MovieApi movieApi) {
        super(movieApi);
    }

    @Override
    public Observable<List<Movie>> getMoviePopularResponse(String apiKey) {
        return mMovieApi.getMoviePopularResponse(apiKey)
                .map(new Function<MovieResponse, List<Movie>>() {

                    @Override
                    public List<Movie> apply(MovieResponse movieResponse) throws Exception {
                        return movieResponse.getMovieList();
                    }
                });
    }

    @Override
    public Observable<List<Movie>> getMovieTopRateResponse(String apiKey) {
        return mMovieApi.getMovieTopRatedResponse(apiKey)
                .map(new Function<MovieResponse, List<Movie>>() {

                    @Override
                    public List<Movie> apply(MovieResponse movieResponse) throws Exception {
                        return movieResponse.getMovieList();
                    }
                });
    }

    @Override
    public Observable<List<Movie>> getMovieNowPlayingResponse(String apiKey) {
        return mMovieApi.getMovieNowPlayingResponse(apiKey)
                .map(new Function<MovieResponse, List<Movie>>() {

                    @Override
                    public List<Movie> apply(MovieResponse movieResponse) throws Exception {
                        return movieResponse.getMovieList();
                    }
                });
    }

    @Override
    public Observable<List<Movie>> getMovieUpComingResponse(String apiKey) {
        return mMovieApi.getMovieUpComingResponse(apiKey)
                .map(new Function<MovieResponse, List<Movie>>() {

                    @Override
                    public List<Movie> apply(MovieResponse movieResponse) throws Exception {
                        return movieResponse.getMovieList();
                    }
                });
    }

    @Override
    public Observable<List<Movie>> getMovieByIdGenre(String apiKey, int genreId) {
        return mMovieApi.getMoviesByIdGenre(genreId, apiKey)
                .map(new Function<MovieResponse, List<Movie>>() {

                    @Override
                    public List<Movie> apply(MovieResponse movieResponse) throws Exception {
                        return movieResponse.getMovieList();
                    }
                });
    }

    @Override
    public Observable<Movie> getDetail(String apiKey, int id) {
        return mMovieApi.getDetail(id, apiKey);
    }
}
