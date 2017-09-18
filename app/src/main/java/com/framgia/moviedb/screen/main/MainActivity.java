package com.framgia.moviedb.screen.main;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import com.framgia.moviedb.MyApplication;
import com.framgia.moviedb.R;
import com.framgia.moviedb.databinding.ActivityMainBinding;

/**
 * Created by workspace on 18/09/2017.
 */

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private MainContract.ViewModel mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MyApplication.setColorStatusBar(this);
        mViewModel = new MainViewModel();
        MainContract.Presenter presenter = new MainPresenter(mViewModel);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mViewModel.setPresenter(presenter);
        binding.setViewModel((MainViewModel) mViewModel);
    }

    @Override
    public void onBackPressed() {
        ((MainViewModel) mViewModel).onBackPressed();
        super.onBackPressed();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return false;
    }
}
