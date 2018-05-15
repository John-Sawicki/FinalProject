package com.example.android.steptwojokes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class StepTwoMainActivity extends AppCompatActivity {
    private String[] redneckJokes;
    private String redneckJoke;
    private int jokeCount = 0;
    Button tellJokeButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step_two_main);
        tellJokeButton = findViewById(R.id.goToStepTwoButton);
        Bundle extras = getIntent().getExtras();
        if(extras!=null){
            redneckJokes = extras.getStringArray("jokes");
            Log.d("Step two activity", redneckJokes[0]);
        }
        tellJokeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                redneckJoke = redneckJokes[jokeCount];
                Toast.makeText(getApplicationContext(), redneckJoke, Toast.LENGTH_SHORT).show();
                jokeCount+=1;
                if(jokeCount==redneckJokes.length) jokeCount=0;    //return to the first joke
            }
        });
    }
}
