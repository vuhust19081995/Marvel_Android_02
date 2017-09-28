package com.framgia.moviedb.data.source.remote;

import com.framgia.moviedb.data.model.Video;
import com.framgia.moviedb.data.model.VideoResponse;
import com.framgia.moviedb.data.source.VideoDataSource;
import com.framgia.moviedb.data.source.remote.api.service.MovieApi;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import java.util.List;

/**
 * Created by workspace on 28/09/2017.
 */

public class VideoRemoteDataSource extends BaseRemoteDataSoure
        implements VideoDataSource.RemoteDataSource {
    public VideoRemoteDataSource(MovieApi movieApi) {
        super(movieApi);
    }

    @Override
    public Observable<List<Video>> getVideosByIdMovie(String apiKey, int id) {
        return mMovieApi.getVideosByIdMovie(id, apiKey)
                .map(new Function<VideoResponse, List<Video>>() {

                    @Override
                    public List<Video> apply(VideoResponse videoResponse) throws Exception {
                        return videoResponse.getVideos();
                    }
                });
    }
}
