package com.framgia.moviedb.screen.main.movies;

import com.framgia.moviedb.BuildConfig;
import com.framgia.moviedb.data.model.Movie;
import com.framgia.moviedb.data.source.MovieRepository;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import java.util.List;

import static com.framgia.moviedb.utils.Constant.CATEGORY_NOW_PLAYING;
import static com.framgia.moviedb.utils.Constant.CATEGORY_POPULAR;
import static com.framgia.moviedb.utils.Constant.CATEGORY_UPCOMING;

/**
 * Created by workspace on 26/09/2017.
 */

public class MovieFragmentPresenter implements MovieFragmentContract.Presenter {
    private MovieFragmentContract.ViewModel mViewModel;

    private MovieRepository mMovieRepository;

    private CompositeDisposable mCompositeDisposable;

    public MovieFragmentPresenter(MovieFragmentContract.ViewModel viewModel,
            MovieRepository movieRepository) {
        mViewModel = viewModel;
        mMovieRepository = movieRepository;
        mCompositeDisposable = new CompositeDisposable();
    }

    @Override
    public void onStart() {

    }

    @Override
    public void onStop() {

    }

    @Override
    public void getMoviesResponse(String category) {
        Observable<List<Movie>> observable = null;
        switch (category) {
            case CATEGORY_NOW_PLAYING:
                observable = mMovieRepository.getMovieNowPlayingResponse(BuildConfig.API_KEY);
                break;
            case CATEGORY_UPCOMING:
                observable = mMovieRepository.getMovieUpComingResponse(BuildConfig.API_KEY);
                break;
            case CATEGORY_POPULAR:
                observable = mMovieRepository.getMoviePopularResponse(BuildConfig.API_KEY);
                break;
            default:
                // todo later
                break;
        }
        if (observable == null) {
            return;
        }
        mCompositeDisposable.add(observable.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableObserver<List<Movie>>() {
                    @Override
                    public void onNext(List<Movie> value) {
                        mViewModel.onGetMoviesSuccess(value);
                    }

                    @Override
                    public void onError(Throwable e) {
                        mViewModel.onGetMoviesError(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                }));
    }

    public void onDestroy() {
        mCompositeDisposable.dispose();
    }
}
