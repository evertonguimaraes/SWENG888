package edu.psu.sweng888.lessonfour_data.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.List;

import edu.psu.sweng888.lessonfour_data.R;
import edu.psu.sweng888.lessonfour_data.database.MovieDatabaseHelper;
import edu.psu.sweng888.lessonfour_data.model.Movie;
import edu.psu.sweng888.lessonfour_data.model.MovieAdapter;
import edu.psu.sweng888.lessonfour_data.model.SpacingItemDecorator;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;
    private MovieDatabaseHelper databaseHelper;
    private MovieAdapter movieAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);
        databaseHelper = new MovieDatabaseHelper(this);

        this.deleteDatabase("movie_database");
        List<Movie> movies = databaseHelper.getAllMovies();
        if(movies.isEmpty()){
            databaseHelper.populateMoviesDatabase();
            movies = databaseHelper.getAllMovies();
        }

        movieAdapter = new MovieAdapter(movies);
        recyclerView.setAdapter(movieAdapter);
        recyclerView.addItemDecoration(new SpacingItemDecorator(0));
        layoutManager = new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

    }
}