package com.framgia.moviedb.screen.home;

/**
 * Listens to user actions from the UI ({@link HomeFragment}), retrieves the data and
 * updates
 * the UI as required.
 */
public final class HomeFragmentPresenter implements HomeFragmentContract.Presenter {

    private final HomeFragmentContract.ViewModel mViewModel;

    public HomeFragmentPresenter(HomeFragmentContract.ViewModel viewModel) {
        mViewModel = viewModel;
    }

    @Override
    public void onStart() {
    }

    @Override
    public void onStop() {
    }
}
