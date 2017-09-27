package com.framgia.moviedb.data.source.remote;

import com.framgia.moviedb.data.model.Genre;
import com.framgia.moviedb.data.model.GenreResponse;
import com.framgia.moviedb.data.source.GenreDataSoure;
import com.framgia.moviedb.data.source.remote.api.service.MovieApi;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import java.util.List;

/**
 * Created by workspace on 27/09/2017.
 */

public class GenreRemoteDataSource extends BaseRemoteDataSoure
        implements GenreDataSoure.RemoteDataSource {
    public GenreRemoteDataSource(MovieApi movieApi) {
        super(movieApi);
    }

    @Override
    public Observable<List<Genre>> getGenres(String apiKey) {
        return mMovieApi.getGenres(apiKey).map(new Function<GenreResponse, List<Genre>>() {
            @Override
            public List<Genre> apply(GenreResponse genreResponse) throws Exception {
                return genreResponse.getGenreList();
            }
        });
    }
}
