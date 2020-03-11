package com.example.retrofitbooks.view;

import com.example.retrofitbooks.model.BooksResponse;

public interface ViewInterface {
    void onBindPresenter();
    void searchBooks();
    void displayData(BooksResponse data);
    void displayErrorMessage(String errorMessage);
}
