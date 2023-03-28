package edu.psu.sweng888.lessonthree_intents.model;

import edu.psu.sweng888.lessonthree_intents.R;
import android.content.Context;
import android.widget.ArrayAdapter;
import androidx.annotation.NonNull;
import java.util.List;

public class CourseListAdapter extends ArrayAdapter<Course> {

    public CourseListAdapter(@NonNull Context context, @NonNull List<Course> objects) {
       super(context, R.layout.list_item, objects);
    }

}
