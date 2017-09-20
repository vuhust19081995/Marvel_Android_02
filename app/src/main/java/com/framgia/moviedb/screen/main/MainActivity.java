package com.framgia.moviedb.screen.main;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.framgia.moviedb.R;
import com.framgia.moviedb.databinding.ActivityMainBinding;

/**
 * Created by workspace on 18/09/2017.
 */

public class MainActivity extends AppCompatActivity {
    private MainContract.ViewModel mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mViewModel = new MainViewModel();
        MainContract.Presenter presenter = new MainPresenter(mViewModel);
        mViewModel.setPresenter(presenter);
        binding.setViewModel((MainViewModel) mViewModel);
    }

    @Override
    public void onBackPressed() {
        ((MainViewModel) mViewModel).onBackPressed();
        super.onBackPressed();
    }
}
