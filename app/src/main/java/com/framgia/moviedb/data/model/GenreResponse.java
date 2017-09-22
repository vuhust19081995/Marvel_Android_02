package com.framgia.moviedb.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * Created by workspace on 22/09/2017.
 */

public class GenreResponse {
    @SerializedName("genres")
    @Expose
    private List<Genre> mGenreList;

    public List<Genre> getGenreList() {
        return mGenreList;
    }

    public void setGenreList(List<Genre> genreList) {
        mGenreList = genreList;
    }
}
