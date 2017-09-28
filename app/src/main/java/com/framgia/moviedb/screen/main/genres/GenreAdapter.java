package com.framgia.moviedb.screen.main.genres;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.framgia.moviedb.R;
import com.framgia.moviedb.data.model.Genre;
import com.framgia.moviedb.databinding.ItemGenreBinding;
import com.framgia.moviedb.screen.OnRecyclerViewItemClickListener;
import java.util.List;

/**
 * Created by workspace on 27/09/2017.
 */

public class GenreAdapter extends RecyclerView.Adapter<GenreAdapter.BindingHolder> {
    private List<Genre> mGenres;

    private OnRecyclerViewItemClickListener<Genre> mOnItemClickListener;

    public GenreAdapter(List<Genre> genres) {
        mGenres = genres;
    }

    @Override
    public BindingHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ItemGenreBinding binding =
                DataBindingUtil.inflate(inflater, R.layout.item_genre, parent, false);
        return new BindingHolder(binding, mOnItemClickListener);
    }

    @Override
    public void onBindViewHolder(BindingHolder holder, int position) {
        holder.bind(mGenres.get(position));
    }

    @Override
    public int getItemCount() {
        return mGenres != null ? mGenres.size() : 0;
    }

    public void setOnItemClickListener(OnRecyclerViewItemClickListener<Genre> onItemClickListener) {
        mOnItemClickListener = onItemClickListener;
    }

    /**
     * hold item
     */
    public static class BindingHolder extends RecyclerView.ViewHolder {
        private ItemGenreBinding mBinding;
        private OnRecyclerViewItemClickListener<Genre> mOnItemClickListener;

        public BindingHolder(ItemGenreBinding binding,
                OnRecyclerViewItemClickListener<Genre> onItemClickListener) {
            super(binding.getRoot());
            mBinding = binding;
            mOnItemClickListener = onItemClickListener;
        }

        public void bind(Genre genre) {
            if (genre != null) {
                mBinding.setGenre(genre);
                mBinding.setItemClickListener(mOnItemClickListener);
                mBinding.executePendingBindings();
            }
        }
    }
}
