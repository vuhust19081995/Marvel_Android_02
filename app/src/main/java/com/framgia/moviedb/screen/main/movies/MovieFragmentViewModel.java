package com.framgia.moviedb.screen.main.movies;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.widget.Toast;
import com.framgia.moviedb.BR;
import com.framgia.moviedb.data.model.Movie;
import com.framgia.moviedb.screen.MovieAdapter;
import com.framgia.moviedb.screen.OnRecyclerViewItemClickListener;
import java.util.List;

/**
 * Created by workspace on 26/09/2017.
 */

public class MovieFragmentViewModel extends BaseObservable
        implements MovieFragmentContract.ViewModel, OnRecyclerViewItemClickListener<Movie> {

    public static final int SPAN_COUNT = 2;

    private Context mContext;

    private MovieFragmentContract.Presenter mPresenter;

    private String mCategoryName;

    private MovieAdapter mMovieAdapter;

    public MovieFragmentViewModel(Context context, String categoryName) {
        mContext = context;
        mCategoryName = categoryName;
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
    public void setPresenter(MovieFragmentContract.Presenter presenter) {
        mPresenter = presenter;
        mPresenter.getMoviesResponse(getCategoryName());
    }

    @Override
    public void onGetMoviesSuccess(List<Movie> movies) {
        setMovieAdapter(new MovieAdapter(movies));
    }

    @Override
    public void onGetMoviesError(String msg) {
        Toast.makeText(mContext, msg, Toast.LENGTH_SHORT).show();
    }

    @Bindable
    public String getCategoryName() {
        return mCategoryName;
    }

    @Bindable
    public MovieAdapter getMovieAdapter() {
        return mMovieAdapter;
    }

    public void setMovieAdapter(MovieAdapter movieAdapter) {
        mMovieAdapter = movieAdapter;
        mMovieAdapter.setOnItemClickListener(this);
        notifyPropertyChanged(BR.movieAdapter);
    }

    @Override
    public void onClick(Movie movie) {
        // todo later
    }
}
