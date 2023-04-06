package edu.psu.sweng888.lessonfour_contentprovider;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.DecelerateInterpolator;
import android.widget.ProgressBar;

public class SplashScreenActivity extends AppCompatActivity {

    private ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        /** Configure and start the progress bar animation */
        mProgressBar = findViewById(R.id.splash_progress_bar);
        ObjectAnimator animation = ObjectAnimator.ofInt(mProgressBar, "progress", 0, 100);
        animation.setDuration(4000);
        animation.setInterpolator(new DecelerateInterpolator());
        animation.start();

        /** Start the next activity after a delay */
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreenActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, 4000); 
    }
}