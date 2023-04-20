package edu.psu.sweng888.lessonsix_googlemaps;

import android.app.SearchManager;
import android.content.Context;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.provider.BaseColumns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import java.util.List;

public class SearchAdapter extends CursorAdapter {

    private List<String> mPredictionList;

    public SearchAdapter(Context context, List<String> predictionList) {
        super(context, null, false);
        mPredictionList = predictionList;
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        // Inflate a new view for the suggestion items
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(android.R.layout.simple_list_item_1, parent, false);

        return view;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        // Get the text view from the view and set the suggestion text
        TextView textView = view.findViewById(android.R.id.text1);
        textView.setText(cursor.getString(cursor.getColumnIndexOrThrow(SearchManager.SUGGEST_COLUMN_TEXT_1)));
    }

    @Override
    public Cursor runQueryOnBackgroundThread(CharSequence constraint) {
        // Create a new cursor with the search suggestions
        MatrixCursor cursor = new MatrixCursor(new String[]{BaseColumns._ID, SearchManager.SUGGEST_COLUMN_TEXT_1});

        if (constraint != null) {
            for (int i = 0; i < mPredictionList.size(); i++) {
                if (mPredictionList.get(i).toLowerCase().startsWith(constraint.toString().toLowerCase())) {
                    cursor.addRow(new Object[]{i, mPredictionList.get(i)});
                }
            }
        }

        return cursor;
    }
}
