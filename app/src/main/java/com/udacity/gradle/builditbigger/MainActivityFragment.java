package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.javajokeslib.JavaJokes;
import com.example.android.steptwojokes.StepTwoMainActivity;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.example.android.redneckJokes.RedneckJokes;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {
    private Button stepTwoButton, btn_java;
    private TextView tv_javaJoke;
    RedneckJokes mRedneckJokesClass = new RedneckJokes();
    String[] redneckJokes = mRedneckJokesClass.redneckJokes;    //array has 4 jokes
    JavaJokes mJavaJokes = new JavaJokes(); //imported java class
    String[] jokes = mJavaJokes.dadJokes;
    String toastJoke;
    int jokeCount =0;
    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);
        btn_java = root.findViewById(R.id.java_button);
        stepTwoButton = root.findViewById(R.id.goToStepTwoButton);
        tv_javaJoke = root.findViewById(R.id.tv_javaJoke);
        AdView mAdView = (AdView) root.findViewById(R.id.adView);
        // Create an ad request. Check logcat output for the hashed device ID to
        // get test ads on a physical device. e.g.
        // "Use AdRequest.Builder.addTestDevice("ABCDEF012345") to get test ads on this device."
        AdRequest adRequest = new AdRequest.Builder()
               // .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        mAdView.loadAd(adRequest);
        btn_java.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toastJoke = jokes[jokeCount];
                Log.d("mainFrag java joke",toastJoke );
                Toast.makeText(getActivity(), toastJoke, Toast.LENGTH_LONG).show();
                jokeCount+=1;
                if(jokeCount==jokes.length) jokeCount=0;    //return to the first joke
                tv_javaJoke.setText(toastJoke);
            }
        });
        stepTwoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(" mainFrag stepTwoIntent", redneckJokes[0]);
                Intent newModuleIntent = new Intent(getContext(), StepTwoMainActivity.class);
                newModuleIntent.putExtra("jokes", redneckJokes);
                startActivity(newModuleIntent);
            }
        });
        return root;
    }

}
