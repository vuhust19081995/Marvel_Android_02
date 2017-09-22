package com.framgia.moviedb.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by workspace on 22/09/2017.
 */

public class ActorResponse extends BaseModel {
    @SerializedName("cast")
    @Expose
    private List<Actor> mActorList = new ArrayList<>();

    public List<Actor> getActorList() {
        return mActorList;
    }

    public void setActorList(List<Actor> actorList) {
        mActorList = actorList;
    }
}
