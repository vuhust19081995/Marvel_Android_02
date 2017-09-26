package com.framgia.moviedb.screen.main.movies;

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
import com.framgia.moviedb.databinding.FragmentMovieBinding;
import com.framgia.moviedb.screen.BaseFragment;

import static com.framgia.moviedb.utils.Constant.BUNDLE_CATEGORY;

/**
 * Created by workspace on 26/09/2017.
 */

public class MovieFragment extends BaseFragment {

    private MovieFragmentContract.ViewModel mViewModel;

    private MovieFragmentContract.Presenter mPresenter;

    private MovieRepository mMovieRepository;

    public static MovieFragment newInstance(String category) {
        MovieFragment fragment = new MovieFragment();
        Bundle bundle = new Bundle();
        bundle.putString(BUNDLE_CATEGORY, category);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mMovieRepository =
                new MovieRepository(new MovieRemoteDataSoure(MovieServiceClient.getInstance()));
        String category = getArguments().getString(BUNDLE_CATEGORY);
        mViewModel = new MovieFragmentViewModel(getActivity(), category);
        mPresenter = new MovieFragmentPresenter(mViewModel, mMovieRepository);
        mViewModel.setPresenter(mPresenter);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
        FragmentMovieBinding binding =
                DataBindingUtil.inflate(inflater, R.layout.fragment_movie, container, false);
        binding.setViewModel((MovieFragmentViewModel) mViewModel);
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
        ((MovieFragmentPresenter) mPresenter).onDestroy();
        super.onDestroy();
    }
}
