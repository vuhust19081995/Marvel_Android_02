package com.framgia.moviedb.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by workspace on 22/09/2017.
 */

public class Producer extends BaseModel {
    @SerializedName("name")
    @Expose
    private String mNameProducer;

    public String getNameProducer() {
        return mNameProducer;
    }

    public void setNameProducer(String nameProducer) {
        mNameProducer = nameProducer;
    }
}
