package com.framgia.moviedb.data.source;

import com.framgia.moviedb.data.model.MovieResponse;
import io.reactivex.Observable;

/**
 * Created by workspace on 22/09/2017.
 */

public interface MovieDataSource {

    /**
     * Declear interface RemoteDataSource
     */

    interface RemoteDataSource {
        Observable<MovieResponse> getMoviePopularResponse();
    }
}
