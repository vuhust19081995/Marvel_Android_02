package com.framgia.moviedb.screen;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.framgia.moviedb.R;
import com.framgia.moviedb.data.model.Movie;
import com.framgia.moviedb.databinding.ItemMovieBinding;
import java.util.List;

/**
 * Created by workspace on 26/09/2017.
 */

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MoviewViewHolder> {
    private List<Movie> mMovies;
    private OnRecyclerViewItemClickListener<Movie> mClickListener;

    public MovieAdapter(List<Movie> movies) {
        mMovies = movies;
    }

    @Override
    public MoviewViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemMovieBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.item_movie, parent, false);
        return new MoviewViewHolder(binding, mClickListener);
    }

    @Override
    public void onBindViewHolder(MoviewViewHolder holder, int position) {
        holder.bind(mMovies.get(position));
    }

    @Override
    public int getItemCount() {
        return mMovies != null ? mMovies.size() : 0;
    }

    public void setOnItemClickListener(OnRecyclerViewItemClickListener<Movie> onItemClickListener) {
        mClickListener = onItemClickListener;
    }
    /**
     * Create ViewHolder
     */
    class MoviewViewHolder extends RecyclerView.ViewHolder {
        private ItemMovieBinding mBinding;
        private OnRecyclerViewItemClickListener<Movie> mClickListener;

        MoviewViewHolder(ItemMovieBinding binding,
                OnRecyclerViewItemClickListener<Movie> onItemClickListener) {
            super(binding.getRoot());
            mBinding = binding;
            mClickListener = onItemClickListener;
        }

        public void bind(Movie movie) {
            mBinding.setMovie(movie);
            mBinding.setItemClickListener(mClickListener);
            mBinding.executePendingBindings();
        }
    }
}
