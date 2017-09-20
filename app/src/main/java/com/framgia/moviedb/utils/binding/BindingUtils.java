package com.framgia.moviedb.utils.binding;

import android.app.Activity;
import android.content.Context;
import android.databinding.BindingAdapter;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.widget.FrameLayout;
import com.framgia.moviedb.R;
import com.framgia.moviedb.screen.home.slidebanner.BannerViewpagerAdapter;
import com.framgia.moviedb.utils.Constant;

/**
 * Created by workspace on 18/09/2017.
 */

public final class BindingUtils {

    private BindingUtils() {

    }

    @BindingAdapter({ "bind:statusDrawer" })
    public static void setStatusDrawerLayout(DrawerLayout drawerLayout, String status) {
        if (status == null) {
            return;
        }
        if (status.equals(Constant.DRAWER_OPEN)) {
            drawerLayout.openDrawer(GravityCompat.START);
        } else if (status.equals(Constant.DRAWER_CLOSE)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        }
    }

    @BindingAdapter({ "bind:toggleDrawer" })
    public static void setToggleDrawer(DrawerLayout drawerLayout, Toolbar toolbar) {
        Context context = drawerLayout.getContext();
        ActionBarDrawerToggle toggle =
                new ActionBarDrawerToggle((Activity) context, drawerLayout, toolbar,
                        R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.setDrawerListener(toggle);
        toggle.syncState();
    }

    @BindingAdapter({ "bind:navigationviewListener" })
    public static void setNavigationViewListener(NavigationView navigationView,
            NavigationView.OnNavigationItemSelectedListener listener) {
        navigationView.setNavigationItemSelectedListener(listener);
    }

    @BindingAdapter({ "bind:fragmentManager", "bind:fragment" })
    public static void replaceFragment(FrameLayout frameLayout, FragmentManager fragmentManager,
            Fragment fragment) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        int id = frameLayout.getId();
        transaction.replace(id, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @BindingAdapter({ "bind:viewPagerAdapter" })
    public static void setViewPagerAdapter(ViewPager viewPager,
            BannerViewpagerAdapter viewPagerAdapter) {
        viewPager.setAdapter(viewPagerAdapter);
    }

}
