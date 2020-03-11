package com.example.retrofitbooks.presenter;

import com.example.retrofitbooks.model.BooksResponse;
import com.example.retrofitbooks.model.Network;
import com.example.retrofitbooks.view.ViewInterface;

public class Presenter implements PresenterInterface {
    private ViewInterface view;
    private Network network;

    public Presenter(Network network) {
        this.network = network;
    }


    @Override
    public void onBind(ViewInterface view) {
        this.view = view;
    }

    @Override
    public void unBind() {
        view = null;
    }

    @Override
    public void searchBooksCriteria(String query,
                                    Integer maxResults,
                                    String bookType) {
        initNetwork(query, maxResults, bookType);
    }

    @Override
    public void sendData(BooksResponse data) {
        view.displayData(data);
    }

    @Override
    public void sendErrorMessage(String errorMessage) {
        view.displayErrorMessage(errorMessage);
    }

    @Override
    public void initNetwork(String query,
                            Integer results,
                            String type) {

        Network network = new Network(this);
        network.initApi(query, results, type);
    }
}



