package com.vsevolodvisnevskij.homework.hw7;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;

import com.vsevolodvisnevskij.homework.R;
import com.vsevolodvisnevskij.homework.base.BaseMVVMFragment;
import com.vsevolodvisnevskij.homework.base.BaseViewModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class ConsumerFragment extends BaseMVVMFragment {

    public ConsumerFragment() {
        // Required empty public constructor
    }


    @Override
    public int provideLayoutId() {
        return R.layout.fragment_consumer;
    }

    @Override
    public BaseViewModel provideViewModel(Bundle bundle) {
        if (bundle != null) {
            return (ConsumerViewModel) bundle.getSerializable(KEY_VIEW_MODEL);
        }
        ConsumerViewModel consumerViewModel = new ConsumerViewModel();
        consumerViewModel.setContract((ObservableContract) getActivity());
        return consumerViewModel;
    }

    public static ConsumerFragment getInstance() {
        Bundle bundle = new Bundle();
        ConsumerFragment fragment = new ConsumerFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable(KEY_VIEW_MODEL, viewModel);
    }
}
