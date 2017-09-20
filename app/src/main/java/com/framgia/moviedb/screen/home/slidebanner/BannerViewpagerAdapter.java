package com.framgia.moviedb.screen.home.slidebanner;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import static com.framgia.moviedb.utils.Constant.BANNER_COUNT;

/**
 * Created by workspace on 20/09/2017.
 */

public class BannerViewpagerAdapter extends FragmentStatePagerAdapter {
    public BannerViewpagerAdapter(FragmentManager fm) {
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
