package com.example.retrofitbooks.view;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.retrofitbooks.R;
import com.example.retrofitbooks.model.BookItem;
import com.example.retrofitbooks.model.BooksResponse;
import com.example.retrofitbooks.presenter.Presenter;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity
        implements ViewInterface, BookItemListener {

    Presenter presenter;
    BookDetailFragment fragment;
    BooksAdapter adapter;
    RecyclerView recyclerView;
    TextInputLayout tilInput;
    TextInputLayout tilMaxResult;
    Spinner printTypes;
    ImageButton btnSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        tilInput = findViewById(R.id.til_search_books);
        tilMaxResult = findViewById(R.id.til_search_max_results);
        recyclerView = findViewById(R.id.recycler_view);
        btnSearch = findViewById(R.id.btn_search);
        adapter = new BooksAdapter(this);
        printTypes = findViewById(R.id.sp_print_type);

        btnSearch.setOnClickListener(view -> {
            searchBooks();
        });

        printTypes.setAdapter(new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                getResources().getStringArray(R.array.print_types)
        ));

        recyclerView.setLayoutManager(new LinearLayoutManager(this,
                LinearLayoutManager.HORIZONTAL,
                false));
        recyclerView.setAdapter(adapter);

        onBindPresenter();
    }

    @Override
    public void onBindPresenter() {
        presenter = new Presenter();
        presenter.onBind(this);
    }

    @Override
    public void searchBooks() {
        presenter.searchBooksCriteria(tilInput.getEditText().getText().toString(),
                Integer.parseInt(tilMaxResult.getEditText().getText().toString()),
                printTypes.getSelectedItem().toString());
    }

    @Override
    public void displayData(BooksResponse data) {
        adapter.setDataSet(data);
    }

    @Override
    public void displayErrorMessage(String errorMessage) {
        Toast.makeText(this,
                errorMessage, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showBookInfo(BookItem item) {
        //todo pass data to the Fragment
        fragment = BookDetailFragment.getInstance(item);
        getSupportFragmentManager().beginTransaction().replace(
                android.R.id.content,
                fragment
        ).commit();
        getSupportFragmentManager().executePendingTransactions();
        fragment.setData();
    }
}