package com.framgia.moviedb.screen.home;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.framgia.moviedb.R;
import com.framgia.moviedb.data.source.MovieRepository;
import com.framgia.moviedb.data.source.remote.MovieRemoteDataSoure;
import com.framgia.moviedb.data.source.remote.api.service.MovieServiceClient;
import com.framgia.moviedb.databinding.FragmentHomeBinding;
import com.framgia.moviedb.screen.BaseFragment;

/**
 * HomeFragment Screen.
 */
public class HomeFragment extends BaseFragment {

    private HomeFragmentContract.ViewModel mViewModel;

    private HomeFragmentContract.Presenter mPresenter;

    private MovieRepository mMovieRepository;

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mMovieRepository =
                new MovieRepository(new MovieRemoteDataSoure(MovieServiceClient.getInstance()));
        mViewModel = new HomeFragmentViewModel(getActivity(), getChildFragmentManager(),
                mMovieRepository);
        mPresenter = new HomeFragmentPresenter(mViewModel, mMovieRepository);
        mViewModel.setPresenter(mPresenter);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {

        FragmentHomeBinding binding =
                DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false);
        binding.setViewModel((HomeFragmentViewModel) mViewModel);
        return binding.getRoot();
    }

    @Override
    public void onStart() {
        super.onStart();
        mViewModel.onStart();
    }

    @Override
    public void onStop() {
        mViewModel.onStop();
        super.onStop();
    }

    @Override
    public void onDestroy() {
        ((HomeFragmentPresenter) mPresenter).onDestroy();
        super.onDestroy();
    }
}
