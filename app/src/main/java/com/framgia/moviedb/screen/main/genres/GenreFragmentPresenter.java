package com.framgia.moviedb.screen.main.genres;

import com.framgia.moviedb.BuildConfig;
import com.framgia.moviedb.data.model.Genre;
import com.framgia.moviedb.data.source.GenreRepository;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import java.util.List;

/**
 * Listens to user actions from the UI ({@link GenreFragment}), retrieves the data and
 * updates
 * the UI as required.
 */
public class GenreFragmentPresenter implements GenreFragmentContract.Presenter {

    private GenreFragmentContract.ViewModel mViewModel;

    private GenreRepository mGenreRepository;

    private CompositeDisposable mDisposable;

    public GenreFragmentPresenter(GenreFragmentContract.ViewModel viewModel,
            GenreRepository genreRepository) {
        mViewModel = viewModel;
        mGenreRepository = genreRepository;
        mDisposable = new CompositeDisposable();
    }

    @Override
    public void onStart() {
    }

    @Override
    public void onStop() {
    }

    @Override
    public void onDestroy() {
        mDisposable.dispose();
    }

    @Override
    public void getGenres() {
        mDisposable.add(mGenreRepository.getGenres(BuildConfig.API_KEY)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableObserver<List<Genre>>() {

                    @Override
                    public void onNext(List<Genre> value) {
                        mViewModel.onGetGenresSuccess(value);
                    }

                    @Override
                    public void onError(Throwable e) {
                        mViewModel.onGetGenresError(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                }));
    }
}
