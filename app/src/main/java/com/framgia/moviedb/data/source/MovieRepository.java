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
}
