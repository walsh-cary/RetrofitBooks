package com.example.retrofitbooks.di;

import com.example.retrofitbooks.model.Network;
import com.example.retrofitbooks.presenter.Presenter;

import dagger.Module;
import dagger.Provides;

@Module
public class PresenterModule {

    @Provides
    public Presenter providesPresenter(Network network) {
        return new Presenter(network);
    }
}
