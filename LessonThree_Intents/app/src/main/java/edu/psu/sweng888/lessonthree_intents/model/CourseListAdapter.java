package edu.psu.sweng888.lessonthree_intents.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

import edu.psu.sweng888.lessonthree_intents.R;

public class CourseListAdapter extends ArrayAdapter<Course> {

    public CourseListAdapter(@NonNull Context context, @NonNull List<Course> objects) {
       super(context, R.layout.list_item, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listViewElement = convertView;
        if (listViewElement == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            listViewElement = inflater.inflate(R.layout.list_item, parent, false);
        }

        Course course = getItem(position);
        TextView courseIdView = listViewElement.findViewById(R.id.course_id);
        TextView courseCreditsView = listViewElement.findViewById(R.id.course_credits);
        TextView courseDescriptionView = listViewElement.findViewById(R.id.course_description);

        courseIdView.setText("SWENG " + course.getCourseID());
        courseCreditsView.setText("Credits: " + course.getNumberOfCredits());
        courseDescriptionView.setText(course.getCourseDescription());

        return listViewElement;
    }
}
