package com.framgia.moviedb.screen.detail;

import com.framgia.moviedb.BuildConfig;
import com.framgia.moviedb.data.model.Actor;
import com.framgia.moviedb.data.model.Movie;
import com.framgia.moviedb.data.model.Video;
import com.framgia.moviedb.data.source.ActorRepository;
import com.framgia.moviedb.data.source.MovieRepository;
import com.framgia.moviedb.data.source.VideoRepository;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import java.util.List;

/**
 * Listens to user actions from the UI ({@link DetailActivity}), retrieves the data and
 * updates
 * the UI as required.
 */
public class DetailActivityPresenter implements DetailActivityContract.Presenter {
    private DetailActivityContract.ViewModel mViewModel;

    private VideoRepository mVideoRepository;

    private MovieRepository mMovieRepository;

    private ActorRepository mActorRepository;

    private CompositeDisposable mDisposable;

    public DetailActivityPresenter(DetailActivityContract.ViewModel viewModel,
            MovieRepository movieRepository, ActorRepository actorRepository,
            VideoRepository videoRepository) {
        mViewModel = viewModel;
        mVideoRepository = videoRepository;
        mMovieRepository = movieRepository;
        mActorRepository = actorRepository;
        mDisposable = new CompositeDisposable();
    }

    @Override
    public void onStart() {
    }

    @Override
    public void onStop() {
    }

    @Override
    public void getVideoResponse(int id) {
        mDisposable.add(mVideoRepository.getVideosByIdMovie(BuildConfig.API_KEY, id)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableObserver<List<Video>>() {

                    @Override
                    public void onNext(List<Video> value) {
                        mViewModel.onGetVideoResponseSuccess(value);
                    }

                    @Override
                    public void onError(Throwable e) {
                        mViewModel.onGetVideoResponseError(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                }));
    }

    @Override
    public void getActorsResponse(int id) {
        mDisposable.add(mActorRepository.getActors(BuildConfig.API_KEY, id)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableObserver<List<Actor>>() {

                    @Override
                    public void onNext(List<Actor> value) {
                        mViewModel.onGetActorResponseSuccess(value);
                    }

                    @Override
                    public void onError(Throwable e) {
                        mViewModel.onGetActorResponseError(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                }));
    }

    @Override
    public void getMovieDetail(int id) {
        mDisposable.add(mMovieRepository.getDetail(BuildConfig.API_KEY, id)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableObserver<Movie>() {

                    @Override
                    public void onNext(Movie value) {
                        mViewModel.onGetMovieDetailSuccess(value);
                    }

                    @Override
                    public void onError(Throwable e) {
                        mViewModel.onGetMovieDetailError(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                }));
    }

    @Override
    public void onDestroy() {
        mDisposable.dispose();
    }
}
