package edu.psu.sweng888.lessonfive_firebaseui.model;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class FirebaseBookDAO implements BookDAO{

    private DatabaseReference database;

    public FirebaseBookDAO(){
        database = FirebaseDatabase.getInstance().getReference().child("books");
    }
    @Override
    public void addBook(Book book) {
        String key = database.push().getKey();
        if (key != null) {
            database.child(key).setValue(book);
        }
    }

    @Override
    public void updateBook(Book book) {
        database.child(book.getTitle()).setValue(book);
    }

    @Override
    public void removeBook(Book book) {
        database.child(book.getTitle()).removeValue();
    }

    // New getBooks() method
    public List<Book> getBooks() {
        List<Book> bookList = new ArrayList<>();

        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    Book book = dataSnapshot.getValue(Book.class);
                    bookList.add(book);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        return bookList;
    }
}
