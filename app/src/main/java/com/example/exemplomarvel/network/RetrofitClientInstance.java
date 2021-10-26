package com.example.exemplomarvel.network;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import timber.log.Timber;

public class RetrofitClientInstance {
    private static MarvelService instance;
    private static final String BASE_URL = "https://gateway.marvel.com/v1/public/";

    public static MarvelService getInstance() {
        if (instance == null) {
            GsonBuilder gsonBuilder = new GsonBuilder();
            Gson gson = gsonBuilder.create();
            HttpLoggingInterceptor httpLoggingInterceptor = new
                    HttpLoggingInterceptor(message -> Timber.i(message));

            httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

            OkHttpClient okHttpClient = new OkHttpClient()
                    .newBuilder()
                    .addInterceptor(httpLoggingInterceptor)
                    .build();

            Retrofit retrofit = new retrofit2.Retrofit.Builder()
                    .client(okHttpClient)
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();

            instance = retrofit.create(MarvelService.class);

            }
        return instance;
    }


}


