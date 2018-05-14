package com.udacity.gradle.builditbigger;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import com.example.android.javajokeslib.JavaJokes;


public class MainActivity extends AppCompatActivity {
    JavaJokes mJavaJokes = new JavaJokes(); //imported java class
    String[] jokes = mJavaJokes.dadJokes;
    String toastJoke;
    int jokeCount =0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    //TODO Step 1: import JavaJokes class String[] to tell jokes when the button is pressed.
    public void tellJoke(View view) {
        toastJoke = jokes[jokeCount];
        Toast.makeText(this, toastJoke, Toast.LENGTH_SHORT).show();
        jokeCount+=1;
        if(jokeCount==jokes.length) jokeCount=0;    //return to the first joke
    }


}
