package com.framgia.moviedb.screen.main;

import com.framgia.moviedb.screen.BasePresenter;
import com.framgia.moviedb.screen.BaseViewModel;

/**
 * Created by workspace on 18/09/2017.
 */

public interface MainContract {
    /**
     * Declear interface viewmodel
     */
    interface ViewModel extends BaseViewModel<Presenter> {

    }

    /**
     * Declear interface presenter
     */
    interface Presenter extends BasePresenter {

    }
}
