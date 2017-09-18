package com.framgia.moviedb.screen.main;

/**
 * Created by workspace on 18/09/2017.
 */

public class MainPresenter implements MainContract.Presenter {
    private MainContract.ViewModel mViewModel;

    public MainPresenter(MainContract.ViewModel viewModel) {
        mViewModel = viewModel;
    }

    @Override
    public void onStart() {

    }

    @Override
    public void onStop() {

    }
}
