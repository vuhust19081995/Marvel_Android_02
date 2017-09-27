package com.framgia.moviedb.data.source;

import com.framgia.moviedb.data.model.Genre;
import io.reactivex.Observable;
import java.util.List;

/**
 * Created by workspace on 27/09/2017.
 */

public interface GenreDataSoure {

    /**
     * Declear interface RemoteDataSource
     */

    interface RemoteDataSource {
        Observable<List<Genre>> getGenres(String apiKey);
    }
}
