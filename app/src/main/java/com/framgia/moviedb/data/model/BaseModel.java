package com.framgia.moviedb.data.model;

import android.databinding.BaseObservable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by workspace on 22/09/2017.
 */

public class BaseModel extends BaseObservable {
    @SerializedName("id")
    @Expose
    private int mId;

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }
}
