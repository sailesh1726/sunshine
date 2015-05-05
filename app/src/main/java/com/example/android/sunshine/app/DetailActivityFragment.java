package com.example.android.sunshine.app;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A placeholder fragment containing a simple view.
 */
public class DetailActivityFragment extends Fragment {

    private View rootView;
    private TextView forecastTextView;
    private String forecast;
    public DetailActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView=  inflater.inflate(R.layout.fragment_detail, container, false);

        forecastTextView = (TextView) rootView.findViewById(R.id.forecast_textview);
        Intent intent = getActivity().getIntent();

        forecast=intent.getStringExtra(Intent.EXTRA_TEXT);

        if(forecast!=null)
        forecastTextView.setText(forecast);

        return rootView;
    }
}
