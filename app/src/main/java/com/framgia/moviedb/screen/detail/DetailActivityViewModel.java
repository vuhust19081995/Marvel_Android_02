package com.framgia.moviedb.screen.detail;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.widget.Toast;
import com.framgia.moviedb.BR;
import com.framgia.moviedb.data.model.Actor;
import com.framgia.moviedb.data.model.Movie;
import com.framgia.moviedb.data.model.Video;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import java.util.List;

/**
 * Exposes the data to be used in the DetailActivity screen.
 */

public class DetailActivityViewModel extends BaseObservable
        implements DetailActivityContract.ViewModel, YouTubePlayer.OnInitializedListener {
    private static final int RECOVERY_DIALOG_REQUEST = 1;
    private static final int POSITION = 0;
    private Context mContext;

    private DetailActivityContract.Presenter mPresenter;

    private int mMovieId;

    private String mVideoId;

    private Movie mMovie;

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
        mVideoId = videos.get(POSITION).getKeyVideo();
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
        setMovie(movie);
    }

    @Override
    public void onGetMovieDetailError(String msg) {
        Toast.makeText(mContext, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider,
            YouTubePlayer youTubePlayer, boolean b) {
        if (!b) {
            youTubePlayer.loadVideo(mVideoId);
        }
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider,
            YouTubeInitializationResult youTubeInitializationResult) {
    }

    @Bindable
    public Movie getMovie() {
        return mMovie;
    }

    public void setMovie(Movie movie) {
        mMovie = movie;
        notifyPropertyChanged(BR.movie);
    }
}
