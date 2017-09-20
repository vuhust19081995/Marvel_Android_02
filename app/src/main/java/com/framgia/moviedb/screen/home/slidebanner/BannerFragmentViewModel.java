package com.framgia.moviedb.screen.home.slidebanner;

/**
 * Exposes the data to be used in the BannerFragment screen.
 */

public class BannerFragmentViewModel implements BannerFragmentContract.ViewModel {

    private BannerFragmentContract.Presenter mPresenter;

    public BannerFragmentViewModel() {
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
}
