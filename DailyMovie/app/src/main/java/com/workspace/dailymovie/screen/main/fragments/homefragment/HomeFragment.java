package com.workspace.dailymovie.screen.main.fragments.homefragment;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.workspace.dailymovie.R;
import com.workspace.dailymovie.databinding.FragmentHomeBinding;

/**
 * Created by workspace on 17/09/2017.
 */

public class HomeFragment extends Fragment {
    private FragmentHomeBinding mBinding;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false);
        View view = mBinding.getRoot();

        return view;
    }
}
