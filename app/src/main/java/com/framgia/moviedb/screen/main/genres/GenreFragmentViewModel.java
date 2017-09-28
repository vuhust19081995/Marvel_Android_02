package com.framgia.moviedb.screen.main.genres;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.widget.Toast;
import com.framgia.moviedb.BR;
import com.framgia.moviedb.data.model.Genre;
import com.framgia.moviedb.screen.OnRecyclerViewItemClickListener;
import java.util.List;

/**
 * Exposes the data to be used in the GenreFragment screen.
 */

public class GenreFragmentViewModel extends BaseObservable
        implements GenreFragmentContract.ViewModel, OnRecyclerViewItemClickListener<Genre> {
    private Context mContext;

    private GenreFragmentContract.Presenter mPresenter;

    private GenreAdapter mAdapter;

    public GenreFragmentViewModel(Context context) {
        mContext = context;
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
    public void onDestroy() {
        mPresenter.onDestroy();
    }

    @Override
    public void setPresenter(GenreFragmentContract.Presenter presenter) {
        mPresenter = presenter;
        mPresenter.getGenres();
    }

    @Override
    public void onGetGenresSuccess(List<Genre> genres) {
        setAdapter(new GenreAdapter(genres));
    }

    @Override
    public void onGetGenresError(String msg) {
        Toast.makeText(mContext, msg, Toast.LENGTH_SHORT).show();
    }

    @Bindable
    public GenreAdapter getAdapter() {
        return mAdapter;
    }

    public void setAdapter(GenreAdapter adapter) {
        mAdapter = adapter;
        mAdapter.setOnItemClickListener(this);
        notifyPropertyChanged(BR.adapter);
    }

    @Override
    public void onClick(Genre genre) {
        // todo later
    }
}
