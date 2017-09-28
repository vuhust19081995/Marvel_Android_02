package com.framgia.moviedb.data.source;

import com.framgia.moviedb.data.model.Video;
import io.reactivex.Observable;
import java.util.List;

/**
 * Created by workspace on 28/09/2017.
 */

public class VideoRepository implements VideoDataSource.RemoteDataSource {
    private VideoDataSource.RemoteDataSource mVideoRemoteDataSource;

    public VideoRepository(VideoDataSource.RemoteDataSource videoRemoteDataSource) {
        mVideoRemoteDataSource = videoRemoteDataSource;
    }

    @Override
    public Observable<List<Video>> getVideosByIdMovie(String apiKey, int id) {
        return mVideoRemoteDataSource.getVideosByIdMovie(apiKey, id);
    }
}
