package com.framgia.moviedb.screen.home.slidebanner;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.framgia.moviedb.data.model.Movie;
import java.util.List;

import static com.framgia.moviedb.utils.Constant.BANNER_COUNT;

/**
 * Created by workspace on 21/09/2017.
 */

public class BannerViewPagerAdapter extends FragmentPagerAdapter {
    private List<Movie> mMovies;

    public BannerViewPagerAdapter(FragmentManager fm, List<Movie> movies) {
        super(fm);
        mMovies = movies;
    }

    @Override
    public Fragment getItem(int position) {
        String path = mMovies.get(position).getBackDropPath();
        int idMovie = mMovies.get(position).getId();
        return BannerFragment.newInstance(path, idMovie);
    }

    @Override
    public int getCount() {
        return BANNER_COUNT;
    }
}
