package com.framgia.moviedb.screen.main;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.view.MenuItem;
import com.framgia.moviedb.BR;
import com.framgia.moviedb.R;

import static com.framgia.moviedb.utils.Constant.DRAWER_CLOSE;
import static com.framgia.moviedb.utils.Constant.DRAWER_OPEN;

/**
 * Created by workspace on 18/09/2017.
 */

public class MainViewModel extends BaseObservable
        implements MainContract.ViewModel, NavigationView.OnNavigationItemSelectedListener {
    private MainContract.Presenter mPresenter;
    private String mDrawerState;

    public MainViewModel() {
        setDrawerState(DRAWER_CLOSE);
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
                // todo later
                break;
            default:
                // todo later
                break;
        }
        setDrawerState(DRAWER_CLOSE);
        return true;
    }
}
