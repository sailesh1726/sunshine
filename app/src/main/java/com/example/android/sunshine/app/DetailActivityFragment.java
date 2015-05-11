package com.example.android.sunshine.app;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.ShareActionProvider;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A placeholder fragment containing a simple view.
 */
public class DetailActivityFragment extends Fragment {


    private static final String FORECAST_SHARE_HASHTAG = " #SunshineApp";

    private View rootView;
    private TextView forecastTextView;
    private String forecast;
    public DetailActivityFragment() {
        setHasOptionsMenu(true);
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

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.detailfragment,menu);

        MenuItem menuItem= menu.findItem(R.id.action_share);

        ShareActionProvider shareActionProvider= (ShareActionProvider) MenuItemCompat.getActionProvider(menuItem);

        if(shareActionProvider!=null){
            shareActionProvider.setShareIntent(createShareForecastIntent());
        }
    }

    private Intent createShareForecastIntent(){
        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);
        shareIntent.setType("text/plain");
        shareIntent.putExtra(Intent.EXTRA_TEXT,forecast+FORECAST_SHARE_HASHTAG);

        return shareIntent;
    }
}
