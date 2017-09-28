package com.framgia.moviedb.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by workspace on 27/09/2017.
 */

public class Video {
    @SerializedName("key")
    @Expose
    private String mKeyVideo;

    public String getKeyVideo() {
        return mKeyVideo;
    }

    public void setKeyVideo(String keyVideo) {
        mKeyVideo = keyVideo;
    }
}
