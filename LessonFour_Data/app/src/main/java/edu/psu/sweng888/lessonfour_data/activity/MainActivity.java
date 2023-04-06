package edu.psu.sweng888.lessonfour_data.activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import edu.psu.sweng888.lessonfour_data.R;
import edu.psu.sweng888.lessonfour_data.database.MovieDatabaseHelper;
import edu.psu.sweng888.lessonfour_data.model.Movie;
import edu.psu.sweng888.lessonfour_data.model.MovieAdapter;
import edu.psu.sweng888.lessonfour_data.model.SpacingItemDecorator;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;
    private MovieDatabaseHelper databaseHelper;
    private MovieAdapter movieAdapter;
    private Button mButtonBackSelection;
    private FloatingActionButton mFloatingActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);
        mFloatingActionButton = findViewById(R.id.floating_action_button);
        mButtonBackSelection = findViewById(R.id.button_back_to_selection_activity);

        mFloatingActionButton.setOnClickListener(this);
        mButtonBackSelection.setOnClickListener(this);

        databaseHelper = new MovieDatabaseHelper(this);

        List<Movie> movies;
        Intent intent = getIntent();
        String option_selected = (String) intent.getStringExtra("option_selected");

        if(databaseHelper.isDatabaseEmpty()){
            databaseHelper.populateMoviesDatabase();
            movies = databaseHelper.getAllMovies();
        }

        if (option_selected.equals("all")){
            movies = databaseHelper.getAllMovies();
        } else {
            movies = databaseHelper.getMoviesByCategory(option_selected.toLowerCase());
        }

        movieAdapter = new MovieAdapter(movies);
        recyclerView.setAdapter(movieAdapter);
        recyclerView.addItemDecoration(new SpacingItemDecorator(0));
        layoutManager = new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.floating_action_button: showDialog(); break;
            case R.id.button_back_to_selection_activity: goBackToPreviousActivity(); break;
            default: break;
        }
    }

    private void goBackToPreviousActivity(){
        Intent intent = new Intent(MainActivity.this, SelectionActivity.class);
        startActivity(intent);
    }

    private void showDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Add Movie");
        builder.setMessage("Do you want to add a new movie?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                startActivity(new Intent(MainActivity.this, AddMovieActivity.class));
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "The action was cancelled", Toast.LENGTH_SHORT).show();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

}