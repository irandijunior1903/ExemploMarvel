package com.example.exemplomarvel.network;

import com.example.exemplomarvel.models.ComicDataWrapper;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MarvelService {
    @GET("comics")
    Call<ComicDataWrapper> getAllComics(
            @Query("ts") String ts,
            @Query("apikey") String apikey,
            @Query("hash") String hash

    );


}
