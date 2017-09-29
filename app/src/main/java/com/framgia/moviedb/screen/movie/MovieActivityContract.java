package com.framgia.moviedb.screen.movie;

import com.framgia.moviedb.data.model.Movie;
import com.framgia.moviedb.screen.BasePresenter;
import com.framgia.moviedb.screen.BaseViewModel;
import java.util.List;

/**
 * This specifies the contract between the view and the presenter.
 */
interface MovieActivityContract {
    /**
     * View.
     */
    interface ViewModel extends BaseViewModel<Presenter> {
        void getMoviesSuccess(List<Movie> movies);

        void getMoviesError(String msg);

        void onDestroy();
    }

    /**
     * Presenter.
     */
    interface Presenter extends BasePresenter {
        void getMoviesByIdGenre(int genreId);

        void onDestroy();
    }
}
