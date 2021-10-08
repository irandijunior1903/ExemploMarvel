package com.example.exemplomarvel;


import com.example.exemplomarvel.models.Comic;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MarvelService {

    @GET
    Call<List<Comic>> getAllComics();
}
