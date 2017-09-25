package com.framgia.moviedb.data.source;

import com.framgia.moviedb.data.model.MovieResponse;
import io.reactivex.Observable;

/**
 * Created by workspace on 22/09/2017.
 */

public class MovieRepository implements MovieDataSource.RemoteDataSource {
    private MovieDataSource.RemoteDataSource mMovieRemoteDataSource;

    public MovieRepository(MovieDataSource.RemoteDataSource movieRemoteDataSource) {
        mMovieRemoteDataSource = movieRemoteDataSource;
    }

    @Override
    public Observable<MovieResponse> getMoviePopularResponse() {
        return mMovieRemoteDataSource.getMoviePopularResponse();
    }
}
