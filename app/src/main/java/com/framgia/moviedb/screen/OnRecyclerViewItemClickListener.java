package com.framgia.moviedb.screen;

/**
 * Created by workspace on 28/09/2017.
 *
 * @param <T> This is the type parameter
 */

public interface OnRecyclerViewItemClickListener<T> {
    void onClick(T item);
}
