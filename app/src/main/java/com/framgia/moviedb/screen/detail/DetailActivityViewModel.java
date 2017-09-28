package com.framgia.moviedb.screen.detail;

import android.content.Context;
import android.databinding.BaseObservable;
import android.widget.Toast;
import com.framgia.moviedb.data.model.Actor;
import com.framgia.moviedb.data.model.Movie;
import com.framgia.moviedb.data.model.Video;
import java.util.List;

/**
 * Exposes the data to be used in the DetailActivity screen.
 */

public class DetailActivityViewModel extends BaseObservable
        implements DetailActivityContract.ViewModel {

    private static final int RECOVERY_DIALOG_REQUEST = 1;
    private Context mContext;

    private DetailActivityContract.Presenter mPresenter;

    private int mMovieId;

    private String mVideoId;

    public DetailActivityViewModel(Context context, int movieId) {
        mContext = context;
        mMovieId = movieId;
    }

    @Override
    public void onStart() {
        mPresenter.onStart();
    }

    @Override
    public void onStop() {
        mPresenter.onStop();
    }

    @Override
    public void onDestroy() {
        mPresenter.onDestroy();
    }

    @Override
    public void onActivityResult(int requestCode) {

    }

    @Override
    public void setPresenter(DetailActivityContract.Presenter presenter) {
        mPresenter = presenter;
        mPresenter.getVideoResponse(mMovieId);
        mPresenter.getActorsResponse(mMovieId);
        mPresenter.getMovieDetail(mMovieId);
    }

    @Override
    public void onGetVideoResponseSuccess(List<Video> videos) {
        mVideoId = videos.get(0).getKeyVideo();
    }

    @Override
    public void onGetVideoResponseError(String msg) {
        Toast.makeText(mContext, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onGetActorResponseSuccess(List<Actor> actors) {

    }

    @Override
    public void onGetActorResponseError(String msg) {
        Toast.makeText(mContext, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onGetMovieDetailSuccess(Movie movie) {

    }

    @Override
    public void onGetMovieDetailError(String msg) {
        Toast.makeText(mContext, msg, Toast.LENGTH_SHORT).show();
    }
}
