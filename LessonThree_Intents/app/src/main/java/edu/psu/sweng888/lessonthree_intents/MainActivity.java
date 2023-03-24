package edu.psu.sweng888.lessonthree_intents;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private ImageView mImageView;
    private Button mButtonMakeCall;
    private Button mButtonSendEmail;
    private Button mButtonSendSMS;
    private Button mButtonCreateNote;
    private Button mButtonListCourses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mImageView = (ImageView) findViewById(R.id.imageViewAvatar);
        mImageView.setImageResource(R.mipmap.ic_alien);

        /** buttons that will be associated with the use of Implicit Intents */
        mButtonMakeCall = findViewById(R.id.buttonMakeCall);
        mButtonSendEmail = findViewById(R.id.buttonSendEmail);
        mButtonSendSMS = findViewById(R.id.buttonSendSMS);
        mButtonCreateNote = findViewById(R.id.buttonCreateNote);

        /** Button that will be associated with the use of Explicit Intent */
        mButtonListCourses = findViewById(R.id.buttonCheckListCourses);
    }
}