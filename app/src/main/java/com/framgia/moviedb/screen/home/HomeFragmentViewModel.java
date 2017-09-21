package com.framgia.moviedb.screen.home;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.support.v4.app.FragmentManager;
import com.framgia.moviedb.BR;
import com.framgia.moviedb.screen.home.slidebanner.BannerViewPagerAdapter;

/**
 * Exposes the data to be used in the HomeFragment screen.
 */

public class HomeFragmentViewModel extends BaseObservable
        implements HomeFragmentContract.ViewModel {

    private HomeFragmentContract.Presenter mPresenter;

    private BannerViewPagerAdapter mViewPagerAdapter;

    public HomeFragmentViewModel(FragmentManager fragmentManager) {
        setViewPagerAdapter(new BannerViewPagerAdapter(fragmentManager));
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

    @Bindable
    public BannerViewPagerAdapter getViewPagerAdapter() {
        return mViewPagerAdapter;
    }

    public void setViewPagerAdapter(BannerViewPagerAdapter viewPagerAdapter) {
        mViewPagerAdapter = viewPagerAdapter;
        notifyPropertyChanged(BR.viewPagerAdapter);
    }
}
