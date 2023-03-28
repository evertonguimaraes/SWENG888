package edu.psu.sweng888.lessonthree_intents.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import static android.Manifest.permission.CALL_PHONE;

import java.util.List;

import edu.psu.sweng888.lessonthree_intents.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, View.OnLongClickListener {

    private ImageView mImageView;
    private Button mButtonOpenDialer;
    private Button mButtonSendEmail;
    private Button mButtonSendSMS;
    private Button mButtonCreateNote;
    private Button mButtonListCourses;

    private Button mButtonOpenFile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mImageView = (ImageView) findViewById(R.id.imageViewAvatar);
        mImageView.setImageResource(R.mipmap.ic_alien);

        mButtonOpenDialer = findViewById(R.id.buttonMakeCall);
        mButtonSendEmail = findViewById(R.id.buttonSendEmail);
        mButtonSendSMS = findViewById(R.id.buttonSendSMS);
        mButtonCreateNote = findViewById(R.id.buttonCreateNote);
        mButtonOpenFile = findViewById(R.id.buttonOpenFile);

        mButtonOpenDialer.setOnClickListener(this);
        mButtonOpenDialer.setOnLongClickListener(this);

        mButtonListCourses = findViewById(R.id.buttonCheckListCourses);

        mButtonSendEmail.setOnClickListener(this);
        mButtonSendSMS.setOnClickListener(this);
        mButtonCreateNote.setOnClickListener(this);
        mButtonListCourses.setOnClickListener(this);
        mButtonOpenFile.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.buttonMakeCall: openDialer(); break;
            case R.id.buttonSendEmail: sendEmail(); break;
            case R.id.buttonSendSMS: openCamera();break;
            case R.id.buttonCreateNote: openGoogleKeepNotes(); break;
            case R.id.buttonOpenFile: openPDFFile(); break;
            case R.id.buttonCheckListCourses: showListCourses(); break;
            default: break;
        }
    }

    @Override
    public boolean onLongClick(View v) {
        makeCall();
        return false;
    }

    private void makeCall(){

    }

    private void openDialer(){

    }

    private void sendEmail(){

    }

    private void openCamera(){

    }

    private void openGoogleKeepNotes(){

    }

    private void openPDFFile(){

    }

    private void showListCourses(){

    }
}