package com.framgia.moviedb.screen.movie;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.widget.Toast;
import com.framgia.moviedb.BR;
import com.framgia.moviedb.data.model.Movie;
import com.framgia.moviedb.screen.MovieAdapter;
import com.framgia.moviedb.screen.OnRecyclerViewItemClickListener;
import com.framgia.moviedb.screen.detail.DetailActivity;
import java.util.List;

/**
 * Exposes the data to be used in the MovieActivity screen.
 */

public class MovieActivityViewModel extends BaseObservable
        implements MovieActivityContract.ViewModel, OnRecyclerViewItemClickListener<Movie> {

    public static final int SPAN_COUNT = 2;

    private Context mContext;

    private MovieActivityContract.Presenter mPresenter;

    private int mGenreId;

    private MovieAdapter mMovieAdapter;

    public MovieActivityViewModel(Context context, int genreId) {
        mContext = context;
        mGenreId = genreId;
    }

    @Override
    public void onStart() {
        mPresenter.onStart();
    }

    @Override
    public void onStop() {
        mPresenter.onStop();
    }

    @Override
    public void setPresenter(MovieActivityContract.Presenter presenter) {
        mPresenter = presenter;
        mPresenter.getMoviesByIdGenre(mGenreId);
    }

    @Override
    public void getMoviesSuccess(List<Movie> movies) {
        setMovieAdapter(new MovieAdapter(movies));
    }

    @Override
    public void getMoviesError(String msg) {
        Toast.makeText(mContext, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroy() {
        mPresenter.onDestroy();
    }

    @Bindable
    public MovieAdapter getMovieAdapter() {
        return mMovieAdapter;
    }

    public void setMovieAdapter(MovieAdapter movieAdapter) {
        mMovieAdapter = movieAdapter;
        movieAdapter.setOnItemClickListener(this);
        notifyPropertyChanged(BR.movieAdapter);
    }

    @Override
    public void onClick(Movie movie) {
        mContext.startActivity(DetailActivity.newIntentDetail(mContext, movie.getId()));
    }
}
