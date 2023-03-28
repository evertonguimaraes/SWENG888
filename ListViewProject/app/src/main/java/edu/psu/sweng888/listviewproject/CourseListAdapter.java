package edu.psu.sweng888.listviewproject;

import static java.security.AccessController.getContext;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

 public class CourseListAdapter extends ArrayAdapter<Course> {

    public CourseListAdapter(Context context, ArrayList<Course> courses) {
        super(context, 0, courses);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item_course, parent, false);
        }
        Course course = getItem(position);

        TextView textViewID = convertView.findViewById(R.id.textview_course_id);
        TextView textViewCredits = convertView.findViewById(R.id.textview_course_credits);
        TextView textViewDescription = convertView.findViewById(R.id.textview_course_description);

        textViewID.setText(String.valueOf(course.getId()));
        textViewCredits.setText(String.valueOf(course.getCredits()));
        textViewDescription.setText(course.getDescription());

        return convertView;
    }
}
