package edu.psu.sweng888.lessonfour_data.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import edu.psu.sweng888.lessonfour_data.model.Movie;

public class MovieDatabaseHelpter extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "movie_database";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_MOVIES = "movies";
    private static final String KEY_ID = "id";
    private static final String KEY_TITLE = "title";
    private static final String KEY_CATEGORY = "category";
    private static final String KEY_YEAR = "year";
    private static final String KEY_RATING = "rating";
    private static final String KEY_DESCRIPTION = "description";



    public MovieDatabaseHelpter(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(createMoviesTable());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion < 2){
            /** Update the database to version 2.
             *  You may need to create new colums or add new tables to the database.
             */
        }
    }

    /** Query to Create the Database*/
    private String createMoviesTable(){
        String QUERY_CREATE_MOVIES_TABLE = "CREATE TABLE " + TABLE_MOVIES + "(" +
                KEY_ID + " INTEGER PRIMARY KEY, "+
                KEY_TITLE + "TEXT," +
                KEY_CATEGORY + "TEXT," +
                KEY_YEAR + "INTEGER," +
                KEY_RATING + "REAL," +
                KEY_DESCRIPTION + "TEXT," +
                ")";
        return QUERY_CREATE_MOVIES_TABLE;
    }

    /** Other queries */
    public void addMovie(Movie movie){
        /** Get a Writable instance of the database */
        SQLiteDatabase database = this.getWritableDatabase();
        /** Create a ContentValues to persist information on the database */
        ContentValues values = new ContentValues();
        /** Populate the object with the values from the Movie to be added.
         *  There is no need to include the ID because it is autogenerated by the SQLIte*/
        values.put(KEY_TITLE, movie.getTitle());
        values.put(KEY_CATEGORY, movie.getCategory());
        values.put(KEY_YEAR, movie.getYear());
        values.put(KEY_RATING, movie.getRating());
        values.put(KEY_DESCRIPTION, movie.getDescription());
        /** Insert the values on the TABLE_MOVIES */
        database.insert(TABLE_MOVIES, null, values);
        /** Close the connection with the database */
    }

    public List<Movie> getMoviesByCategory (String category){
        List<Movie> movieList = new ArrayList<>();

        // TODO IMPLEMENT THE LOGIC

        return  movieList;
    }

    public List<Movie> getAllMovies(){
        List<Movie> movieList = new ArrayList<>();

        //TODO IMPLEMENT THE LOGIC

        return movieList;

    }
}
