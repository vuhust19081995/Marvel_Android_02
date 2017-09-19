package com.framgia.moviedb.screen.home;

import com.framgia.moviedb.screen.BasePresenter;
import com.framgia.moviedb.screen.BaseViewModel;

/**
 * This specifies the contract between the view and the presenter.
 */
interface HomeFragmentContract {
    /**
     * View.
     */
    interface ViewModel extends BaseViewModel<Presenter> {
    }

    /**
     * Presenter.
     */
    interface Presenter extends BasePresenter {
    }
}
