package com.framgia.moviedb.data.source;

import com.framgia.moviedb.data.model.Movie;
import io.reactivex.Observable;
import java.util.List;

/**
 * Created by workspace on 22/09/2017.
 */

public class MovieRepository implements MovieDataSource.RemoteDataSource {
    private MovieDataSource.RemoteDataSource mMovieRemoteDataSource;

    public MovieRepository(MovieDataSource.RemoteDataSource movieRemoteDataSource) {
        mMovieRemoteDataSource = movieRemoteDataSource;
    }

    @Override
    public Observable<List<Movie>> getMoviePopularResponse(String apiKey) {
        return mMovieRemoteDataSource.getMoviePopularResponse(apiKey);
    }

    @Override
    public Observable<List<Movie>> getMovieTopRateResponse(String apiKey) {
        return mMovieRemoteDataSource.getMovieTopRateResponse(apiKey);
    }

    @Override
    public Observable<List<Movie>> getMovieNowPlayingResponse(String apiKey) {
        return mMovieRemoteDataSource.getMovieNowPlayingResponse(apiKey);
    }

    @Override
    public Observable<List<Movie>> getMovieUpComingResponse(String apiKey) {
        return mMovieRemoteDataSource.getMovieUpComingResponse(apiKey);
    }

    @Override
    public Observable<List<Movie>> getMovieByIdGenre(String apiKey, int genreId) {
        return mMovieRemoteDataSource.getMovieByIdGenre(apiKey, genreId);
    }

    @Override
    public Observable<Movie> getDetail(String apiKey, int id) {
        return mMovieRemoteDataSource.getDetail(apiKey, id);
    }
}
