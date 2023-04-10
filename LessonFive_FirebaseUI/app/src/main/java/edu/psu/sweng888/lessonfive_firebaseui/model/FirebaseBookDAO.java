package edu.psu.sweng888.lessonfive_firebaseui.model;

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

    @Override
    public void getBooks(final BookDaoCallback callback) {
        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                List<Book> books = new ArrayList<>();
                for (DataSnapshot bookSnapshot : snapshot.getChildren()) {
                    Book book = bookSnapshot.getValue(Book.class);
                    if (book != null) {
                        books.add(book);
                    }
                }
                callback.onSuccess(books);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                callback.onFailure(error.getMessage());
            }
        });
    }
}
