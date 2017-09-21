package com.framgia.moviedb.screen.home.slidebanner;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import static com.framgia.moviedb.utils.Constant.BANNER_COUNT;

/**
 * Created by workspace on 21/09/2017.
 */

public class BannerViewPagerAdapter extends FragmentPagerAdapter {
    public BannerViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return BannerFragment.newInstance();
    }

    @Override
    public int getCount() {
        return BANNER_COUNT;
    }
}
