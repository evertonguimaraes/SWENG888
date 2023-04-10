package edu.psu.sweng888.lessonfive_firebaseui.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import edu.psu.sweng888.lessonfive_firebaseui.R;
import edu.psu.sweng888.lessonfive_firebaseui.model.Book;
import edu.psu.sweng888.lessonfive_firebaseui.model.BooksAdapter;

public class BooksActivity extends AppCompatActivity {

    private TextView mTextViewEmail;
    private RecyclerView mRecyclerView;
    private DatabaseReference firebaseDatabase;
    private BooksAdapter mBooksAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        mTextViewEmail = findViewById(R.id.text_view_email);
        String email = "Email: "+getIntent().getStringExtra("email");
        mTextViewEmail.setText(email);

        mRecyclerView = findViewById(R.id.book_recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        /** Implement the Call to FirebaseBookDAO */

        firebaseDatabase = FirebaseDatabase.getInstance().getReference("books");

        firebaseDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                List<Book> bookList = new ArrayList<>();
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    Book book = dataSnapshot.getValue(Book.class);
                    bookList.add(book);
                }
                mBooksAdapter = new BooksAdapter(bookList);
                mRecyclerView.setAdapter(mBooksAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.e("BookListActivity", "Error retrieving books from database", error.toException());
            }
        });
    }
}