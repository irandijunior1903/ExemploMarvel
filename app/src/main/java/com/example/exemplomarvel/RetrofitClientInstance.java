package com.example.exemplomarvel;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClientInstance {
    private static Retrofit retrofit;
    private static final String BASE_URL =
            "https://gateway.marvel.com/v1/public/comics?ts=1&apikey=f037ab6e62e83f9bbd49c158cbb0b541&hash=4dd1d9efdd156d320064a627542547c9";

    public static Retrofit getRetrofitInstance() {
        if (retrofit == null) {
            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
