package com.framgia.moviedb.data.source;

import com.framgia.moviedb.data.model.Genre;
import io.reactivex.Observable;
import java.util.List;

/**
 * Created by workspace on 27/09/2017.
 */

public class GenreRepository implements GenreDataSoure.RemoteDataSource {
    private GenreDataSoure.RemoteDataSource mGenreRemoteDataSource;

    public GenreRepository(GenreDataSoure.RemoteDataSource genreRemoteDataSource) {
        mGenreRemoteDataSource = genreRemoteDataSource;
    }

    @Override
    public Observable<List<Genre>> getGenres(String apiKey) {
        return mGenreRemoteDataSource.getGenres(apiKey);
    }
}
