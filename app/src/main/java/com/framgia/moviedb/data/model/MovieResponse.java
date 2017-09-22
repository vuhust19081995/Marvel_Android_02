package com.framgia.moviedb.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by workspace on 22/09/2017.
 */

public class MovieResponse extends BaseModel {
    @SerializedName("total_results")
    @Expose
    private int mTotalResults;
    @SerializedName("total_pages")
    @Expose
    private int mTotalPages;
    @SerializedName("results")
    @Expose
    private List<Movie> mMovieList = new ArrayList<>();

    public int getTotalResults() {
        return mTotalResults;
    }

    public void setTotalResults(int totalResults) {
        mTotalResults = totalResults;
    }

    public int getTotalPages() {
        return mTotalPages;
    }

    public void setTotalPages(int totalPages) {
        mTotalPages = totalPages;
    }

    public List<Movie> getMovieList() {
        return mMovieList;
    }

    public void setMovieList(List<Movie> movieList) {
        mMovieList = movieList;
    }
}
