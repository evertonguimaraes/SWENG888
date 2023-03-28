package edu.psu.sweng888.listviewproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

  public class ActivityC extends AppCompatActivity {

    private TextView mTextViewId;
    private TextView mTextViewCredits;
    private TextView mTextViewDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c);

        // Get the selected Course object from the Intent extras
        Course selectedCourse = (Course) getIntent().getSerializableExtra("selectedCourse");

        // Find the TextViews in the layout
        mTextViewId = findViewById(R.id.textview_id);
        mTextViewCredits = findViewById(R.id.textview_credits);
        mTextViewDescription = findViewById(R.id.textview_description);

        // Set the TextViews with the Course attributes
        mTextViewId.setText(String.valueOf(selectedCourse.getId()));
        mTextViewCredits.setText(String.valueOf(selectedCourse.getCredits()));
        mTextViewDescription.setText(selectedCourse.getDescription());
    }
}