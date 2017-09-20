package com.framgia.moviedb.screen.home.slidebanner;

/**
 * Listens to user actions from the UI ({@link BannerFragment}), retrieves the data and
 * updates
 * the UI as required.
 */
public final class BannerFragmentPresenter implements BannerFragmentContract.Presenter {

    private final BannerFragmentContract.ViewModel mViewModel;

    public BannerFragmentPresenter(BannerFragmentContract.ViewModel viewModel) {
        mViewModel = viewModel;
    }

    @Override
    public void onStart() {
    }

    @Override
    public void onStop() {
    }
}
