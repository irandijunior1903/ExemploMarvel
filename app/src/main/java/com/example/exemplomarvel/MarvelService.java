package com.example.exemplomarvel;


import com.example.exemplomarvel.models.Comic;
import com.example.exemplomarvel.models.ComicDataContainer;
import com.example.exemplomarvel.models.ComicDataWrapper;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MarvelService {
    @GET("comics")
    Call<ComicDataWrapper> getAllComics(
            @Query(value = "ts") String ts,
            @Query(value = "apikey") String apikey,
            @Query(value = "hash") String hash,
            @Query(value = "limit") String limit
    );

}
