package com.framgia.moviedb.screen.detail;

import com.framgia.moviedb.data.model.Actor;
import com.framgia.moviedb.data.model.Movie;
import com.framgia.moviedb.data.model.Video;
import com.framgia.moviedb.screen.BasePresenter;
import com.framgia.moviedb.screen.BaseViewModel;
import java.util.List;

/**
 * This specifies the contract between the view and the presenter.
 */
interface DetailActivityContract {
    /**
     * View.
     */
    interface ViewModel extends BaseViewModel<Presenter> {
        void onGetVideoResponseSuccess(List<Video> videos);

        void onGetVideoResponseError(String msg);

        void onGetActorResponseSuccess(List<Actor> actors);

        void onGetActorResponseError(String msg);

        void onGetMovieDetailSuccess(Movie movie);

        void onGetMovieDetailError(String msg);

        void onDestroy();

        void onActivityResult(int requestCode);
    }

    /**
     * Presenter.
     */
    interface Presenter extends BasePresenter {
        void getVideoResponse(int id);

        void getActorsResponse(int id);

        void getMovieDetail(int id);

        void onDestroy();
    }
}
