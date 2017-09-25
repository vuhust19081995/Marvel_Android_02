package com.framgia.moviedb.data.source.remote;

import com.framgia.moviedb.data.model.MovieResponse;
import com.framgia.moviedb.data.source.MovieDataSource;
import com.framgia.moviedb.data.source.remote.api.service.MovieApi;
import io.reactivex.Observable;

/**
 * Created by workspace on 22/09/2017.
 */

public class MovieRemoteDataSoure extends BaseRemoteDataSoure
        implements MovieDataSource.RemoteDataSource {
    public MovieRemoteDataSoure(MovieApi movieApi) {
        super(movieApi);
    }

    @Override
    public Observable<MovieResponse> getMoviePopularResponse() {
        return mMovieApi.getMoviePopularResponse();
    }
}
