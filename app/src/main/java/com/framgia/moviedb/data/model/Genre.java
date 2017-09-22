package com.framgia.moviedb.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by workspace on 22/09/2017.
 */

public class Genre extends BaseModel {
    @SerializedName("name")
    @Expose
    private String mNameGenre;

    public String getNameGenre() {
        return mNameGenre;
    }

    public void setNameGenre(String nameGenre) {
        mNameGenre = nameGenre;
    }
}
