package com.framgia.moviedb.screen.main.genres;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.framgia.moviedb.R;
import com.framgia.moviedb.data.source.GenreDataSoure;
import com.framgia.moviedb.data.source.GenreRepository;
import com.framgia.moviedb.data.source.remote.GenreRemoteDataSource;
import com.framgia.moviedb.data.source.remote.api.service.MovieServiceClient;
import com.framgia.moviedb.databinding.FragmentGenreBinding;
import com.framgia.moviedb.screen.BaseFragment;

/**
 * GenreFragment Screen.
 */
public class GenreFragment extends BaseFragment {

    private GenreFragmentContract.ViewModel mViewModel;

    public static GenreFragment newInstance() {
        return new GenreFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        GenreDataSoure.RemoteDataSource genreRepository =
                new GenreRepository(new GenreRemoteDataSource(MovieServiceClient.getInstance()));
        mViewModel = new GenreFragmentViewModel(getActivity());

        GenreFragmentContract.Presenter presenter =
                new GenreFragmentPresenter(mViewModel, (GenreRepository) genreRepository);
        mViewModel.setPresenter(presenter);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {

        FragmentGenreBinding binding =
                DataBindingUtil.inflate(inflater, R.layout.fragment_genre, container, false);
        binding.setViewModel((GenreFragmentViewModel) mViewModel);
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
        mViewModel.onDestroy();
        super.onDestroy();
    }
}
