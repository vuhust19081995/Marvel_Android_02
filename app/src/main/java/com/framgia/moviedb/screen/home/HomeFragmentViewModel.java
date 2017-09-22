package com.framgia.moviedb.screen.home;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.support.v4.app.FragmentManager;
import android.widget.Toast;
import com.framgia.moviedb.BR;
import com.framgia.moviedb.data.model.MovieResponse;
import com.framgia.moviedb.data.source.MovieRepository;
import com.framgia.moviedb.screen.home.slidebanner.BannerViewPagerAdapter;

/**
 * Exposes the data to be used in the HomeFragment screen.
 */

public class HomeFragmentViewModel extends BaseObservable
        implements HomeFragmentContract.ViewModel {

    private HomeFragmentContract.Presenter mPresenter;

    private BannerViewPagerAdapter mViewPagerAdapter;

    private MovieRepository mMovieRepository;

    private Context mContext;

    public HomeFragmentViewModel(Context context, FragmentManager fragmentManager,
            MovieRepository movieRepository) {
        setViewPagerAdapter(new BannerViewPagerAdapter(fragmentManager));
        mMovieRepository = movieRepository;
        mContext = context;
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

    @Override
    public void onGetMovieSuccess(MovieResponse movieResponse) {
        // todo later
    }

    @Override
    public void onGetMovieError(String msg) {
        Toast.makeText(mContext, msg, Toast.LENGTH_SHORT).show();
    }
}
