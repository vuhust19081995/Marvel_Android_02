package com.framgia.moviedb.data.source.remote.api.service;

import com.framgia.moviedb.utils.Constant;

/**
 * Created by workspace on 22/09/2017.
 */

public class MovieServiceClient extends ServiceClient {
    private static MovieApi sMovieApi;

    public static void initialize() {
        sMovieApi = createService(Constant.BASE_URL_API, MovieApi.class);
    }

    public static MovieApi getInstance() {
        if (sMovieApi == null) {
            throw new RuntimeException("Need call method NameServiceClient#initialize() first");
        }
        return sMovieApi;
    }
}
