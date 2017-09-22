package com.framgia.moviedb.screen.home;

import com.framgia.moviedb.data.model.MovieResponse;
import com.framgia.moviedb.data.source.MovieRepository;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * Listens to user actions from the UI ({@link HomeFragment}), retrieves the data and
 * updates
 * the UI as required.
 */
public class HomeFragmentPresenter implements HomeFragmentContract.Presenter {

    private final HomeFragmentContract.ViewModel mViewModel;

    private MovieRepository mMovieRepository;
    private CompositeDisposable mCompositeDisposable;

    public HomeFragmentPresenter(HomeFragmentContract.ViewModel viewModel,
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
    public void getMoviePopularResponse() {
        mCompositeDisposable.add(mMovieRepository.getMoviePopularResponse()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableObserver<MovieResponse>() {

                    @Override
                    public void onNext(MovieResponse value) {
                        mViewModel.onGetMovieSuccess(value);
                    }

                    @Override
                    public void onError(Throwable e) {
                        mViewModel.onGetMovieError(e.getMessage());
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
