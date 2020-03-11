package com.example.retrofitbooks.model;

import android.util.Log;

import com.example.retrofitbooks.presenter.Presenter;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Network {
    private Presenter presenter;
    private static final String TAG = "Network";

    public Network(Presenter presenter) {
        this.presenter = presenter;
    }

    public void initApi(String title,
                        Integer maxResults,
                        String type) {
        Log.d(TAG, "initApi: ");

        Retrofit retrofit = new Retrofit.Builder()
                .client(setupClient())
                .baseUrl("https://www.googleapis.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        retrofit.create(BooksApi.class).getBooks(
                maxResults,
                title,
                type).enqueue(new Callback<BooksResponse>() {
            @Override
            public void onResponse(Call<BooksResponse> call,
                                   Response<BooksResponse> response) {
                presenter.sendData(response.body());
            }

            @Override
            public void onFailure(Call<BooksResponse> call, Throwable t) {
                presenter.sendErrorMessage(t.getLocalizedMessage());
            }
        });

    }
    private OkHttpClient setupClient() {
        HttpLoggingInterceptor loggingInterceptor =
                new HttpLoggingInterceptor();
        loggingInterceptor.level(HttpLoggingInterceptor.Level.BASIC);
        return new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .build();
    }
}