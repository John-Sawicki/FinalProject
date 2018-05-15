package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.android.steptwojokes.StepTwoMainActivity;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.example.android.redneckJokes.RedneckJokes;
import com.example.android.steptwojokes.StepTwoMainActivity;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {
    Button stepTwoButton;
    RedneckJokes mRedneckJokesClass = new RedneckJokes();
    String[] redneckJokes = mRedneckJokesClass.redneckJokes;    //array has 4 jokes
    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);
        stepTwoButton = root.findViewById(R.id.goToStepTwoButton);
        AdView mAdView = (AdView) root.findViewById(R.id.adView);
        // Create an ad request. Check logcat output for the hashed device ID to
        // get test ads on a physical device. e.g.
        // "Use AdRequest.Builder.addTestDevice("ABCDEF012345") to get test ads on this device."
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        mAdView.loadAd(adRequest);
        stepTwoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("stepTwoIntent", redneckJokes[0]);
                Intent newModuleIntent = new Intent(getContext(), StepTwoMainActivity.class);
                newModuleIntent.putExtra("jokes", redneckJokes);
                startActivity(newModuleIntent);
            }
        });
        return root;
    }

}
