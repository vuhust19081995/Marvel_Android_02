package com.framgia.moviedb.data.source.remote;

import com.framgia.moviedb.data.model.Actor;
import com.framgia.moviedb.data.model.ActorResponse;
import com.framgia.moviedb.data.source.ActorDataSource;
import com.framgia.moviedb.data.source.remote.api.service.MovieApi;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import java.util.List;

/**
 * Created by workspace on 28/09/2017.
 */

public class ActorRemoteDataSource extends BaseRemoteDataSoure
        implements ActorDataSource.RemoteDataSource {
    public ActorRemoteDataSource(MovieApi movieApi) {
        super(movieApi);
    }

    @Override
    public Observable<List<Actor>> getActors(String apiKey, int id) {
        return mMovieApi.getActorsByIdMovie(id, apiKey)
                .map(new Function<ActorResponse, List<Actor>>() {

                    @Override
                    public List<Actor> apply(ActorResponse actorResponse) throws Exception {
                        return actorResponse.getActorList();
                    }
                });
    }
}
