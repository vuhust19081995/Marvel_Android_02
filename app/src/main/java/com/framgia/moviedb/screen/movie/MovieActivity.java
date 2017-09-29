package com.framgia.moviedb.screen.movie;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.framgia.moviedb.R;
import com.framgia.moviedb.data.source.MovieDataSource;
import com.framgia.moviedb.data.source.MovieRepository;
import com.framgia.moviedb.data.source.remote.MovieRemoteDataSoure;
import com.framgia.moviedb.data.source.remote.api.service.MovieServiceClient;
import com.framgia.moviedb.databinding.ActivityMovieBinding;
import com.framgia.moviedb.utils.Constant;

/**
 * MovieActivity Screen.
 */
public class MovieActivity extends AppCompatActivity {

    private MovieActivityContract.ViewModel mViewModel;

    public static Intent newInstance(Context context, int genreId) {
        Bundle args = new Bundle();
        args.putInt(Constant.BUNDLE_ID_GENRE, genreId);
        Intent intent = new Intent(context, MovieActivity.class);
        intent.putExtras(args);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        int genreId = getIntent().getExtras().getInt(Constant.BUNDLE_ID_GENRE);

        MovieDataSource.RemoteDataSource movieRepository =
                new MovieRepository(new MovieRemoteDataSoure(MovieServiceClient.getInstance()));

        mViewModel = new MovieActivityViewModel(this, genreId);

        MovieActivityContract.Presenter presenter =
                new MovieActivityPresenter(mViewModel, (MovieRepository) movieRepository);
        mViewModel.setPresenter(presenter);

        ActivityMovieBinding binding =
                DataBindingUtil.setContentView(this, R.layout.activity_movie);
        binding.setViewModel((MovieActivityViewModel) mViewModel);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mViewModel.onStart();
    }

    @Override
    protected void onStop() {
        mViewModel.onStop();
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        mViewModel.onDestroy();
        super.onDestroy();
    }
}
