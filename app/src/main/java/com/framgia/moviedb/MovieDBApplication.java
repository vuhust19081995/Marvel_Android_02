package com.framgia.moviedb;

import android.app.Application;
import com.framgia.moviedb.data.source.remote.api.service.MovieServiceClient;

/**
 * Created by workspace on 22/09/2017.
 */

public class MovieDBApplication extends Application{

    @Override
    public void onCreate() {
        super.onCreate();
        MovieServiceClient.initialize();
    }
}
