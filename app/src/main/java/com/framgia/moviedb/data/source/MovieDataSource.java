package com.framgia.moviedb.data.source;

import com.framgia.moviedb.data.model.Movie;
import io.reactivex.Observable;
import java.util.List;

/**
 * Created by workspace on 22/09/2017.
 */

public interface MovieDataSource {

    /**
     * Declear interface RemoteDataSource
     */

    interface RemoteDataSource {
        Observable<List<Movie>> getMoviePopularResponse(String apiKey);
    }
}
