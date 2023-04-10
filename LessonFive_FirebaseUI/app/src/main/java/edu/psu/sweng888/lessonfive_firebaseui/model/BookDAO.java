package edu.psu.sweng888.lessonfive_firebaseui.model;

import java.util.List;

public interface BookDAO {

    void addBook(Book book);
    void updateBook(Book book);
    void removeBook(Book book);
    void getBooks(BookDaoCallback callback);

    interface BookDaoCallback {
        void onSuccess(List<Book> books);
        void onFailure(String errorMessage);
    }
}
