package com.framgia.moviedb.data.source.remote;

import com.framgia.moviedb.data.source.remote.api.service.MovieApi;

/**
 * Created by workspace on 22/09/2017.
 */

public abstract class BaseRemoteDataSoure {
    protected MovieApi mMovieApi;

    public BaseRemoteDataSoure(MovieApi movieApi) {
        mMovieApi = movieApi;
    }
}
