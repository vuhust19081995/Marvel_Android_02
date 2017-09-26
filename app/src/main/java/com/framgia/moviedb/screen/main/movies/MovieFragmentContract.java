package com.framgia.moviedb.screen.main.movies;

import com.framgia.moviedb.data.model.Movie;
import com.framgia.moviedb.screen.BasePresenter;
import com.framgia.moviedb.screen.BaseViewModel;
import java.util.List;

/**
 * Created by workspace on 26/09/2017.
 */

public interface MovieFragmentContract {
    /**
     * View.
     */
    interface ViewModel extends BaseViewModel<Presenter> {
        void onGetMoviesSuccess(List<Movie> movies);

        void onGetMoviesError(String msg);
    }

    /**
     * Presenter.
     */
    interface Presenter extends BasePresenter {
        void getMoviesResponse(String category);
    }
}
