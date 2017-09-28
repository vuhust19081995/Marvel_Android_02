package com.framgia.moviedb.data.source;

import com.framgia.moviedb.data.model.Actor;
import io.reactivex.Observable;
import java.util.List;

/**
 * Created by workspace on 28/09/2017.
 */

public interface ActorDataSource {
    /**
     * Declear interface RemoteDataSource
     */

    interface RemoteDataSource {
        Observable<List<Actor>> getActors(String apiKey, int id);
    }
}
