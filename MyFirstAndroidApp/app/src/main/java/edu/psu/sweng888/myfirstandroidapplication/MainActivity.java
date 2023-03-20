package edu.psu.sweng888.myfirstandroidapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private String currentActivityState = "Current State: ";
    private String methodDescription = "Called When:  ";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(currentActivityState, "onCreate()");
        Log.d(methodDescription, "the activity is first created.");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(currentActivityState, "onStart()");
        Log.d(methodDescription, "the activity is about to become visible.");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(currentActivityState, "onResume()");
        Log.d(methodDescription, "activity will start interacting with the user.");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(currentActivityState, "onPause()");
        Log.d(methodDescription, "the activity is taking focus");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(currentActivityState, "onStop()");
        Log.d(methodDescription, "the activity is no longer visible.");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(currentActivityState, "onDestroy()");
        Log.d(methodDescription, "the activity is destroyed");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(currentActivityState, "onRestart()");
        Log.d(methodDescription, "the activity stopped prior to start.");

    }
}