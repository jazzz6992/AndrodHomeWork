package com.vsevolodvisnevskij.homework.hw7;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.vsevolodvisnevskij.homework.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ConsumerFragment extends Fragment {
    public static final String KEY_COUNTER = "COUNTER";
    private TextView consumerTextView;

    public ConsumerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_consumer, container, false);
        consumerTextView = v.findViewById(R.id.consumer_textView);
        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (savedInstanceState != null) {
            consumerTextView.setText(savedInstanceState.getString(KEY_COUNTER));
        }
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(KEY_COUNTER, consumerTextView.getText().toString());
    }

    public static ConsumerFragment getInstance() {
        Bundle bundle = new Bundle();
        ConsumerFragment fragment = new ConsumerFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    public TextView getConsumerTextView() {
        return getView().findViewById(R.id.consumer_textView);
    }

}
