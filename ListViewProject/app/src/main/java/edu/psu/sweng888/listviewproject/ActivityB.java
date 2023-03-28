package edu.psu.sweng888.listviewproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ActivityB extends AppCompatActivity {

    private ListView mListViewCourses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);

        ArrayList<Course> courses = loadCourseData();
        CourseListAdapter adapter = new CourseListAdapter(ActivityB.this, courses);

        mListViewCourses = findViewById(R.id.listview_courses);
        mListViewCourses.setAdapter(adapter);
        mListViewCourses.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Course selectedCourse = (Course) parent.getItemAtPosition(position);

                Intent intent = new Intent(ActivityB.this, ActivityC.class);
                intent.putExtra("selected_course", selectedCourse);
                startActivity(intent);
            }
        });
    }

    private ArrayList<Course> loadCourseData() {
        ArrayList<Course> courses = new ArrayList<>();

        courses.add(new Course(505, 3, "Design Patterns"));
        courses.add(new Course(585, 3, "Design Patterns"));
        courses.add(new Course(587, 3, "Software Systems Architecture"));

        return  courses;
    }
}