package com.framgia.moviedb.screen.home.slidebanner;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.framgia.moviedb.R;
import com.framgia.moviedb.databinding.FragmentBannerBinding;
import com.framgia.moviedb.screen.BaseFragment;
import com.framgia.moviedb.utils.Constant;

/**
 * BannerFragment Screen.
 */
public class BannerFragment extends BaseFragment {

    private BannerFragmentContract.ViewModel mViewModel;

    public static BannerFragment newInstance(String path) {
        BannerFragment fragment = new BannerFragment();
        Bundle bundle = new Bundle();
        bundle.putString(Constant.BUNDLE_PATH, path);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String mPath = getArguments().getString(Constant.BUNDLE_PATH);
        mViewModel = new BannerFragmentViewModel(mPath);
        BannerFragmentContract.Presenter presenter = new BannerFragmentPresenter(mViewModel);
        mViewModel.setPresenter(presenter);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {

        FragmentBannerBinding binding =
                DataBindingUtil.inflate(inflater, R.layout.fragment_banner, container, false);
        binding.setViewModel((BannerFragmentViewModel) mViewModel);
        return binding.getRoot();
    }

    @Override
    public void onStart() {
        super.onStart();
        mViewModel.onStart();
    }

    @Override
    public void onStop() {
        mViewModel.onStop();
        super.onStop();
    }
}
