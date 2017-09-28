package com.framgia.moviedb.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by workspace on 27/09/2017.
 */

public class VideoResponse extends BaseModel {
    @SerializedName("results")
    @Expose
    private List<Video> mVideos = new ArrayList<>();

    public List<Video> getVideos() {
        return mVideos;
    }

    public void setVideos(List<Video> videos) {
        mVideos = videos;
    }
}
