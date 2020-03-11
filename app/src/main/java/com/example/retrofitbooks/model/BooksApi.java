package com.example.retrofitbooks.model;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface BooksApi {
    //https://www.googleapis.com/books/v1/volumes
    //?q=&maxResults=printType=
    @GET("books/v1/volumes")
    Call<BooksResponse> getBooks(
            @Query("maxResults") Integer resultsNumber,
            @Query("q") String query,
            @Query("printType") String type
    );

}
