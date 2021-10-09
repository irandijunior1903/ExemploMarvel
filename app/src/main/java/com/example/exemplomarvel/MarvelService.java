package com.example.exemplomarvel;


import com.example.exemplomarvel.models.ComicDataContainer;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MarvelService {

    @GET("comics?ts=1&apikey=f037ab6e62e83f9bbd49c158cbb0b541&hash=4dd1d9efdd156d320064a627542547c9")
    Call<ComicDataContainer> getAllComics(@Query("results")int size);
}
