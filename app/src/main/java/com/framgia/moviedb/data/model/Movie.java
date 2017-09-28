package com.framgia.moviedb.data.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * Created by workspace on 22/09/2017.
 */

public class Movie extends BaseModel implements Parcelable {
    public static final Creator<Movie> CREATOR = new Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel in) {
            return new Movie(in);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };
    @SerializedName("poster_path")
    @Expose
    private String mPosterPath;
    @SerializedName("vote_average")
    @Expose
    private float mVoteAverage;
    @SerializedName("title")
    @Expose
    private String mTitle;
    @SerializedName("original_title")
    @Expose
    private String mOrigitalTitle;
    @SerializedName("backdrop_path")
    @Expose
    private String mBackDropPath;
    @SerializedName("overview")
    @Expose
    private String mOverview;
    @SerializedName("production_companies")
    @Expose
    private List<Producer> mProducerList;
    @SerializedName("runtime")
    @Expose
    private int mDuration;
    @SerializedName("genres")
    @Expose
    private List<Genre> mGenreList;

    protected Movie(Parcel in) {
        setId(in.readInt());
        mPosterPath = in.readString();
        mVoteAverage = in.readFloat();
        mTitle = in.readString();
        mOrigitalTitle = in.readString();
        mBackDropPath = in.readString();
        mOverview = in.readString();
        mDuration = in.readInt();
    }

    public String getPosterPath() {
        return mPosterPath;
    }

    public void setPosterPath(String posterPath) {
        mPosterPath = posterPath;
    }

    public float getVoteAverage() {
        return mVoteAverage;
    }

    public void setVoteAverage(float voteAverage) {
        mVoteAverage = voteAverage;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getOrigitalTitle() {
        return mOrigitalTitle;
    }

    public void setOrigitalTitle(String origitalTitle) {
        mOrigitalTitle = origitalTitle;
    }

    public String getBackDropPath() {
        return mBackDropPath;
    }

    public void setBackDropPath(String backDropPath) {
        mBackDropPath = backDropPath;
    }

    public String getOverview() {
        return mOverview;
    }

    public void setOverview(String overview) {
        mOverview = overview;
    }

    public List<Producer> getProducerList() {
        return mProducerList;
    }

    public void setProducerList(List<Producer> producerList) {
        mProducerList = producerList;
    }

    public int getDuration() {
        return mDuration;
    }

    public void setDuration(int duration) {
        mDuration = duration;
    }

    public List<Genre> getGenreList() {
        return mGenreList;
    }

    public void setGenreList(List<Genre> genreList) {
        mGenreList = genreList;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(getId());
        parcel.writeString(mPosterPath);
        parcel.writeFloat(mVoteAverage);
        parcel.writeString(mTitle);
        parcel.writeString(mOrigitalTitle);
        parcel.writeString(mBackDropPath);
        parcel.writeString(mOverview);
        parcel.writeInt(mDuration);
    }
}
