package edu.psu.sweng888.lessonfive_firebaseui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private TextView mTextViewEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        mTextViewEmail = findViewById(R.id.text_view_email);

        Intent intent = getIntent();
        String email = "Email: "+intent.getStringExtra("email");
        mTextViewEmail.setText(email);
    }
}