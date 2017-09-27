package com.framgia.moviedb.screen.main.genres;

import com.framgia.moviedb.data.model.Genre;
import com.framgia.moviedb.screen.BasePresenter;
import com.framgia.moviedb.screen.BaseViewModel;
import java.util.List;

/**
 * This specifies the contract between the view and the presenter.
 */
interface GenreFragmentContract {
    /**
     * View.
     */
    interface ViewModel extends BaseViewModel<Presenter> {
        void onGetGenresSuccess(List<Genre> genres);

        void onGetGenresError(String msg);

        void onDestroy();
    }

    /**
     * Presenter.
     */
    interface Presenter extends BasePresenter {
        void getGenres();

        void onDestroy();
    }
}
