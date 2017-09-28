package com.framgia.moviedb.screen.detail;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import com.framgia.moviedb.R;
import com.framgia.moviedb.data.source.ActorDataSource;
import com.framgia.moviedb.data.source.ActorRepository;
import com.framgia.moviedb.data.source.MovieDataSource;
import com.framgia.moviedb.data.source.MovieRepository;
import com.framgia.moviedb.data.source.VideoDataSource;
import com.framgia.moviedb.data.source.VideoRepository;
import com.framgia.moviedb.data.source.remote.ActorRemoteDataSource;
import com.framgia.moviedb.data.source.remote.MovieRemoteDataSoure;
import com.framgia.moviedb.data.source.remote.VideoRemoteDataSource;
import com.framgia.moviedb.data.source.remote.api.service.MovieServiceClient;
import com.framgia.moviedb.databinding.ActivityDetailBinding;
import com.framgia.moviedb.utils.Constant;
import com.google.android.youtube.player.YouTubeBaseActivity;

/**
 * DetailActivity Screen.
 */
public class DetailActivity extends YouTubeBaseActivity {

    private DetailActivityContract.ViewModel mViewModel;

    public static Intent newIntentDetail(Context context, int id) {
        Bundle bundle = new Bundle();
        bundle.putInt(Constant.BUNDLE_ID_MOVIE, id);
        Intent intent = new Intent(context, DetailActivity.class);
        intent.putExtras(bundle);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int id = getIntent().getIntExtra(Constant.BUNDLE_ID_MOVIE, 0);
        VideoDataSource.RemoteDataSource videoRepository =
                new VideoRepository(new VideoRemoteDataSource(MovieServiceClient.getInstance()));

        ActorDataSource.RemoteDataSource actorRepository =
                new ActorRepository(new ActorRemoteDataSource(MovieServiceClient.getInstance()));

        MovieDataSource.RemoteDataSource movieRepository =
                new MovieRepository(new MovieRemoteDataSoure(MovieServiceClient.getInstance()));
        mViewModel = new DetailActivityViewModel(this, id);

        DetailActivityContract.Presenter presenter =
                new DetailActivityPresenter(mViewModel, (MovieRepository) movieRepository,
                        (ActorRepository) actorRepository, (VideoRepository) videoRepository);
        mViewModel.setPresenter(presenter);

        ActivityDetailBinding binding =
                DataBindingUtil.setContentView(this, R.layout.activity_detail);
        binding.setViewModel((DetailActivityViewModel) mViewModel);
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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        mViewModel.onActivityResult(requestCode);
    }
}
