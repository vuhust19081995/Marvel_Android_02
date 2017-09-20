package com.framgia.moviedb.screen.home;

import android.support.v4.app.FragmentManager;
import com.framgia.moviedb.screen.home.slidebanner.BannerViewpagerAdapter;

/**
 * Exposes the data to be used in the HomeFragment screen.
 */

public class HomeFragmentViewModel implements HomeFragmentContract.ViewModel {

    private HomeFragmentContract.Presenter mPresenter;

    private BannerViewpagerAdapter mViewPagerAdapter;

    public HomeFragmentViewModel(FragmentManager fragmentManager) {
        mViewPagerAdapter = new BannerViewpagerAdapter(fragmentManager);
    }

    @Override
    public void onStart() {
        mPresenter.onStart();
    }

    @Override
    public void onStop() {
        mPresenter.onStop();
    }

    public BannerViewpagerAdapter getViewPagerAdapter() {
        return mViewPagerAdapter;
    }

    @Override
    public void setPresenter(HomeFragmentContract.Presenter presenter) {
        mPresenter = presenter;
    }
}
