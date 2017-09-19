package com.framgia.moviedb.screen.home;

/**
 * Exposes the data to be used in the HomeFragment screen.
 */

public class HomeFragmentViewModel implements HomeFragmentContract.ViewModel {

    private HomeFragmentContract.Presenter mPresenter;

    public HomeFragmentViewModel() {
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
    public void setPresenter(HomeFragmentContract.Presenter presenter) {
        mPresenter = presenter;
    }
}
