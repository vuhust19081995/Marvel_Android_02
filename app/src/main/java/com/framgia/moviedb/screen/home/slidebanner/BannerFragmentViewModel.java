package com.framgia.moviedb.screen.home.slidebanner;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import com.framgia.moviedb.BR;

/**
 * Exposes the data to be used in the BannerFragment screen.
 */

public class BannerFragmentViewModel extends BaseObservable
        implements BannerFragmentContract.ViewModel {

    private BannerFragmentContract.Presenter mPresenter;

    private String mPath;

    public BannerFragmentViewModel(String path) {
        mPath = path;
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

    public void setPath(String path) {
        mPath = path;
        notifyPropertyChanged(BR.path);
    }
}
