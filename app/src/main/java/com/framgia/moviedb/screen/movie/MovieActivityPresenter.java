package com.framgia.moviedb.screen.movie;

import com.framgia.moviedb.BuildConfig;
import com.framgia.moviedb.data.model.Movie;
import com.framgia.moviedb.data.source.MovieRepository;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import java.util.List;

/**
 * Listens to user actions from the UI ({@link MovieActivity}), retrieves the data and
 * updates
 * the UI as required.
 */
public class MovieActivityPresenter implements MovieActivityContract.Presenter {

    private MovieActivityContract.ViewModel mViewModel;

    private MovieRepository mMovieRepository;

    private CompositeDisposable mDisposable;

    public MovieActivityPresenter(MovieActivityContract.ViewModel viewModel,
            MovieRepository movieRepository) {
        mViewModel = viewModel;
        mMovieRepository = movieRepository;
        mDisposable = new CompositeDisposable();
    }

    @Override
    public void onStart() {
    }

    @Override
    public void onStop() {
    }

    @Override
    public void getMoviesByIdGenre(int genreId) {
        mDisposable.add(mMovieRepository.getMovieByIdGenre(BuildConfig.API_KEY, genreId)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableObserver<List<Movie>>() {

                    @Override
                    public void onNext(List<Movie> value) {
                        mViewModel.getMoviesSuccess(value);
                    }

                    @Override
                    public void onError(Throwable e) {
                        mViewModel.getMoviesError(e.getMessage());
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
