package edu.psu.sweng888.lessonfive_fragmentsui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import edu.psu.sweng888.lessonfive_fragmentsui.R;
import edu.psu.sweng888.lessonfive_fragmentsui.adapter.Book;
import edu.psu.sweng888.lessonfive_fragmentsui.adapter.BookAdapter;

public class HomeFragment extends Fragment {

    private BookAdapter bookAdapter;

    private RecyclerView mRecyclerView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        /** Inflate the layout for this fragment */
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        /** Instantiate the RecyclerView */
        mRecyclerView = view.findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        ArrayList<Book> list = getAllBooks();
        bookAdapter = new BookAdapter(list);
        mRecyclerView.setAdapter(bookAdapter);

        return view;
    }

    public ArrayList<Book> getAllBooks(){

        ArrayList<Book> bookList = new ArrayList<Book>();
        bookList.add(new Book("Title 1", "Author 1", "1234567890", "Publisher 1"));
        bookList.add(new Book("Title 2", "Author 2", "0987654321", "Publisher 2"));
        bookList.add(new Book("Title 3", "Author 3", "0987654587", "Publisher 3"));
        bookList.add(new Book("Title 4", "Author 4", "0987638470", "Publisher 4"));

        return bookList;
    }
}
