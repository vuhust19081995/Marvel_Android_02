package com.framgia.moviedb.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by workspace on 22/09/2017.
 */

public class Actor extends BaseModel {
    @SerializedName("character")
    @Expose
    private String mCharacter;
    @SerializedName("name")
    @Expose
    private String mNameActor;

    public String getCharacter() {
        return mCharacter;
    }

    public void setCharacter(String character) {
        mCharacter = character;
    }

    public String getNameActor() {
        return mNameActor;
    }

    public void setNameActor(String nameActor) {
        mNameActor = nameActor;
    }
}
