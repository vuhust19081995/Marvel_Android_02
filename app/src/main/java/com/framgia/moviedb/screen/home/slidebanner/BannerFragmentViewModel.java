package com.framgia.moviedb.screen.home.slidebanner;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import com.framgia.moviedb.screen.detail.DetailActivity;

/**
 * Exposes the data to be used in the BannerFragment screen.
 */

public class BannerFragmentViewModel extends BaseObservable
        implements BannerFragmentContract.ViewModel {

    private Context mContext;

    private BannerFragmentContract.Presenter mPresenter;

    private String mPath;

    private int mMovieId;

    public BannerFragmentViewModel(Context context, String path, int movieId) {
        mContext = context;
        mPath = path;
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
    public void setPresenter(BannerFragmentContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Bindable
    public String getPath() {
        return mPath;
    }

    public void onClick() {
        mContext.startActivity(DetailActivity.newIntentDetail(mContext, mMovieId));
    }
}
