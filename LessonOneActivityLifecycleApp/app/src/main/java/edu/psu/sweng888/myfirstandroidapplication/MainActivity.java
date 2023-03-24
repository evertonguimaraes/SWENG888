package edu.psu.sweng888.myfirstandroidapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private final String CURRENT_STATE = "Current State: ";
    private final String METHOD_CALLED = "Called When:  ";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(CURRENT_STATE, "onCreate()");
        Log.d(METHOD_CALLED, "the activity is first created.");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(CURRENT_STATE, "onStart()");
        Log.d(METHOD_CALLED, "the activity is about to become visible.");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(CURRENT_STATE, "onResume()");
        Log.d(METHOD_CALLED, "activity will be ready to start interacting with the user.");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(CURRENT_STATE, "onPause()");
        Log.d(METHOD_CALLED, "the activity is taking focus");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(CURRENT_STATE, "onStop()");
        Log.d(METHOD_CALLED, "the activity is no longer visible.");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(CURRENT_STATE, "onDestroy()");
        Log.d(METHOD_CALLED, "the activity is destroyed");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(CURRENT_STATE, "onRestart()");
        Log.d(METHOD_CALLED, "the activity stopped prior to start.");
    }
}