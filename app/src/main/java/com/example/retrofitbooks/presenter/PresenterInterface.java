package com.example.retrofitbooks.presenter;

import com.example.retrofitbooks.model.BooksResponse;
import com.example.retrofitbooks.view.ViewInterface;

public interface PresenterInterface {
    void onBind(ViewInterface view);
    void unBind();
    void searchBooksCriteria(
            String query,
            Integer maxResults,
            String bookType);
    void sendData(BooksResponse data);
    void sendErrorMessage(String errorMessage);
    void initNetwork(String query,
                     Integer maxResults,
                     String bookType);
}