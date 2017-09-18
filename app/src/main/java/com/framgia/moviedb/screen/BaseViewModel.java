package com.framgia.moviedb.screen;

/**
 * Created by workspace on 18/09/2017.
 * @param <T> This is the type parameter
 */

public interface BaseViewModel<T extends BasePresenter> {
    void onStart();

    void onStop();

    void setPresenter(T presenter);
}
