package edu.psu.sweng888.lessonfive_fragmentsui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

import java.util.List;

import edu.psu.sweng888.lessonfive_fragmentsui.R;
import edu.psu.sweng888.lessonfive_fragmentsui.adapter.BookAdapter;
import edu.psu.sweng888.lessonfive_fragmentsui.data.Book;
import edu.psu.sweng888.lessonfive_fragmentsui.data.BookDatabaseHelper;

public class AddBookFragment extends Fragment implements View.OnClickListener {

    private EditText titleEditText;
    private EditText authorEditText;
    private EditText isbnEditText;
    private EditText publisherEditText;
    private Button confirmButton;
    private Button clearButton;
    private BookDatabaseHelper bookDatabaseHelper;
    private BookAdapter bookAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_add_book, container, false);

        bookDatabaseHelper = new BookDatabaseHelper(getActivity());
        List<Book> bookList = bookDatabaseHelper.getAllRecords();
        bookAdapter = new BookAdapter(bookList);

        // Get references to the EditText views
        titleEditText = rootView.findViewById(R.id.home_edit_title);
        authorEditText = rootView.findViewById(R.id.home_edit_author);
        isbnEditText = rootView.findViewById(R.id.home_edit_isbn);
        publisherEditText = rootView.findViewById(R.id.home_edit_publisher);

        // Get references to the Button views
        confirmButton = rootView.findViewById(R.id.button_confirm);
        clearButton = rootView.findViewById(R.id.button_clear);

        confirmButton.setOnClickListener(this);
        clearButton.setOnClickListener(this);

        return rootView;
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.button_confirm: confirm(); break;
            case R.id.button_clear: clearFields(); break;
            default: break;
        }
    }

    public void confirm() {
        String title = titleEditText.getText().toString().trim();
        String author = authorEditText.getText().toString().trim();
        String isbn = isbnEditText.getText().toString().trim();
        String publisher = publisherEditText.getText().toString().trim();

        if (title.isEmpty() || author.isEmpty() || isbn.isEmpty() || publisher.isEmpty()) {
            Toast.makeText(getContext(), "Please fill in all fields", Toast.LENGTH_SHORT).show();
        } else {
            Book newBook = new Book(title, author, isbn, publisher);
            bookDatabaseHelper.addBook(newBook);
            List<Book> newList = bookDatabaseHelper.getAllRecords();
            bookAdapter = new BookAdapter(newList);
            bookAdapter.notifyDataSetChanged(); // how to inludw the adapter;
            Toast.makeText(getContext(), "New book added", Toast.LENGTH_SHORT).show();
            clearFields();
        }
    }

    public void clearFields(){
        titleEditText.setText("");
        authorEditText.setText("");
        isbnEditText.setText("");
        publisherEditText.setText("");
    }
}
