package edu.psu.sweng888.lessonthree_intents.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import edu.psu.sweng888.lessonthree_intents.R;
import edu.psu.sweng888.lessonthree_intents.model.Course;
import edu.psu.sweng888.lessonthree_intents.model.CourseListAdapter;

public class SecondActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ListView mListViewCourses;
    private CourseListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        ArrayList<Course> courses = loadCourseDataSWENGProgram();
        adapter = new CourseListAdapter(SecondActivity.this, courses);

        mListViewCourses = findViewById(R.id.listview_courses);
        mListViewCourses.setAdapter(adapter);

        mListViewCourses.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }

    private ArrayList<Course> loadCourseDataSWENGProgram(){

        return new ArrayList<>();
    }
}