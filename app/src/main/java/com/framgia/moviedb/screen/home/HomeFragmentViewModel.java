package com.framgia.moviedb.screen.home;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.support.v4.app.FragmentManager;
import android.widget.Toast;
import com.framgia.moviedb.BR;
import com.framgia.moviedb.data.model.Movie;
import com.framgia.moviedb.data.source.MovieRepository;
import com.framgia.moviedb.screen.MovieAdapter;
import com.framgia.moviedb.screen.home.slidebanner.BannerViewPagerAdapter;
import java.util.List;

/**
 * Exposes the data to be used in the HomeFragment screen.
 */

public class HomeFragmentViewModel extends BaseObservable
        implements HomeFragmentContract.ViewModel {

    public static final int SPAN_COUNT = 2;

    private HomeFragmentContract.Presenter mPresenter;

    private BannerViewPagerAdapter mViewPagerAdapter;

    private MovieRepository mMovieRepository;

    private Context mContext;

    private FragmentManager mFragmentManager;

    private MovieAdapter mMovieAdapter;

    public HomeFragmentViewModel(Context context, FragmentManager fragmentManager,
            MovieRepository movieRepository) {
        mFragmentManager = fragmentManager;
        mMovieRepository = movieRepository;
        mContext = context;
    }

    public static int getSpanCount() {
        return SPAN_COUNT;
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
        mPresenter.getMoviePopularResponse();
        mPresenter.getMovieTopRateResponse();
    }

    @Bindable
    public BannerViewPagerAdapter getViewPagerAdapter() {
        return mViewPagerAdapter;
    }

    public void setViewPagerAdapter(BannerViewPagerAdapter viewPagerAdapter) {
        mViewPagerAdapter = viewPagerAdapter;
        notifyPropertyChanged(BR.viewPagerAdapter);
    }

    @Bindable
    public MovieAdapter getMovieAdapter() {
        return mMovieAdapter;
    }

    public void setMovieAdapter(MovieAdapter movieAdapter) {
        mMovieAdapter = movieAdapter;
        notifyPropertyChanged(BR.movieAdapter);
    }

    @Override
    public void onGetMoviePopularSuccess(List<Movie> movies) {
        setViewPagerAdapter(new BannerViewPagerAdapter(mFragmentManager, movies));
    }

    @Override
    public void onGetMoviePopularError(String msg) {
        Toast.makeText(mContext, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onGetMovieTopRateSuccess(List<Movie> movies) {
        setMovieAdapter(new MovieAdapter(movies));
    }

    @Override
    public void onGetMovieTopRateError(String msg) {
        Toast.makeText(mContext, msg, Toast.LENGTH_SHORT).show();
    }
}
