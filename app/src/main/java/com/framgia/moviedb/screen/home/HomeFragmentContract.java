package com.framgia.moviedb.screen.home;

import com.framgia.moviedb.data.model.Movie;
import com.framgia.moviedb.screen.BasePresenter;
import com.framgia.moviedb.screen.BaseViewModel;
import java.util.List;

/**
 * This specifies the contract between the view and the presenter.
 */
interface HomeFragmentContract {
    /**
     * View.
     */
    interface ViewModel extends BaseViewModel<Presenter> {
        void onGetMoviePopularSuccess(List<Movie> movies);

        void onGetMoviePopularError(String msg);

        void onGetMovieTopRateSuccess(List<Movie> movies);

        void onGetMovieTopRateError(String msg);
    }

    /**
     * Presenter.
     */
    interface Presenter extends BasePresenter {
        void getMoviePopularResponse();

        void getMovieTopRateResponse();
    }
}
