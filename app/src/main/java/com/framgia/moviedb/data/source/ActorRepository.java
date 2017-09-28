package com.framgia.moviedb.data.source;

import com.framgia.moviedb.data.model.Actor;
import io.reactivex.Observable;
import java.util.List;

/**
 * Created by workspace on 28/09/2017.
 */

public class ActorRepository implements ActorDataSource.RemoteDataSource {
    private ActorDataSource.RemoteDataSource mActorRemoteDataSource;

    public ActorRepository(ActorDataSource.RemoteDataSource actorRemoteDataSource) {
        mActorRemoteDataSource = actorRemoteDataSource;
    }

    @Override
    public Observable<List<Actor>> getActors(String apiKey, int id) {
        return mActorRemoteDataSource.getActors(apiKey, id);
    }
}
