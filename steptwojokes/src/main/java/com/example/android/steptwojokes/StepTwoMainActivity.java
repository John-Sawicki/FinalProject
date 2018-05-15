package com.example.android.steptwojokes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class StepTwoMainActivity extends AppCompatActivity {
    private String[] redneckJokes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step_two_main);
        Bundle extras = getIntent().getExtras();
        if(extras!=null){
            redneckJokes = extras.getStringArray("jokes");
            Log.d("Step two activity", redneckJokes[0]);
        }
    }
}
