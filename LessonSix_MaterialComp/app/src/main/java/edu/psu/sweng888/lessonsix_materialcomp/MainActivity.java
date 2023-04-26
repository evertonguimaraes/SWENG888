package edu.psu.sweng888.lessonsix_materialcomp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView mLoginImageView;
    private EditText mEmailEditText;
    private EditText mPasswordEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /** Instantiate all the UI elements */
        mLoginImageView = findViewById(R.id.loginImageView);
        mEmailEditText = findViewById(R.id.edit_text_email);
        mPasswordEditText = findViewById(R.id.edit_text_password);

        /** Fade in the logo */
        ObjectAnimator alphaAnimator = ObjectAnimator
                .ofFloat(mLoginImageView, View.ALPHA, 0f, 1f);
        alphaAnimator.setDuration(500);
        alphaAnimator.start();

        /** Slide up the login form */
        ObjectAnimator translationAnimator = ObjectAnimator
                .ofFloat(mLoginImageView, View.TRANSLATION_Y, 200f, 0f);
        translationAnimator.setDuration(500);
        translationAnimator.start();

        /** You can define the font programmatically */
        /** Set the font family and size for email field */
        mEmailEditText.setTypeface(ResourcesCompat.getFont(this, R.font.robotto_regular));
        mEmailEditText.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);

        /** Set the font family and size for password field */
        mPasswordEditText.setTypeface(ResourcesCompat.getFont(this, R.font.robotto_regular));
        mPasswordEditText.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);


    }
}