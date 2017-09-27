package com.framgia.moviedb.screen.main;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.MenuItem;
import com.framgia.moviedb.BR;
import com.framgia.moviedb.R;
import com.framgia.moviedb.screen.home.HomeFragment;
import com.framgia.moviedb.screen.main.genres.GenreFragment;
import com.framgia.moviedb.screen.main.movies.MovieFragment;
import com.framgia.moviedb.utils.Constant;

import static com.framgia.moviedb.utils.Constant.DRAWER_CLOSE;
import static com.framgia.moviedb.utils.Constant.DRAWER_OPEN;

/**
 * Created by workspace on 18/09/2017.
 */

public class MainViewModel extends BaseObservable
        implements MainContract.ViewModel, NavigationView.OnNavigationItemSelectedListener {
    private MainContract.Presenter mPresenter;
    private String mDrawerState;
    private FragmentManager mFragmentManager;
    private Fragment mFragment;
    private String mCategory;

    public MainViewModel(FragmentManager fragmentManager) {
        setDrawerState(DRAWER_CLOSE);
        mFragmentManager = fragmentManager;
        setCategory(Constant.CATEGORY_HOME);
        setFragment(HomeFragment.newInstance());
    }

    @Override
    public void onStart() {
    }

    @Override
    public void onStop() {

    }

    public void onBackPressed() {
        if (mDrawerState == DRAWER_OPEN) {
            setDrawerState(DRAWER_CLOSE);
        }
    }

    @Override
    public void setPresenter(MainContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Bindable
    public String getDrawerState() {
        return mDrawerState;
    }

    public void setDrawerState(String drawerState) {
        mDrawerState = drawerState;
        notifyPropertyChanged(BR.drawerState);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.menu_item_home:
                setCategory(Constant.CATEGORY_HOME);
                setFragment(HomeFragment.newInstance());
                break;
            case R.id.menu_item_now_playing:
                setCategory(Constant.CATEGORY_NOW_PLAYING);
                setFragment(MovieFragment.newInstance(getCategory()));
                break;
            case R.id.menu_item_popular:
                setCategory(Constant.CATEGORY_POPULAR);
                setFragment(MovieFragment.newInstance(getCategory()));
                break;
            case R.id.menu_item_up_coming:
                setCategory(Constant.CATEGORY_UPCOMING);
                setFragment(MovieFragment.newInstance(getCategory()));
                break;
            case R.id.menu_item_genres:
                setCategory(Constant.CATEGORY_GENRES);
                setFragment(GenreFragment.newInstance());
                break;
            case R.id.menu_item_favorite:
                setCategory(Constant.CATEGORY_FAVORITE);
                setFragment(MovieFragment.newInstance(getCategory()));
                break;
            default:
                // todo later
                break;
        }
        setDrawerState(DRAWER_CLOSE);
        return true;
    }

    public FragmentManager getFragmentManager() {
        return mFragmentManager;
    }

    @Bindable
    public Fragment getFragment() {
        return mFragment;
    }

    public void setFragment(Fragment fragment) {
        mFragment = fragment;
        notifyPropertyChanged(BR.fragment);
    }

    @Bindable
    public String getCategory() {
        return mCategory;
    }

    public void setCategory(String category) {
        mCategory = category;
        notifyPropertyChanged(BR.category);
    }
}
