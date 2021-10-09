package com.example.exemplomarvel;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;

import com.example.exemplomarvel.adapter.CustomAdapter;
import com.example.exemplomarvel.models.Comic;
import com.example.exemplomarvel.models.ComicDataContainer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import timber.log.Timber;

public class MainActivity extends AppCompatActivity {

    CustomAdapter adapter;
    RecyclerView recyclerView;
    Retrofit retrofit;
    ProgressDialog progressDoalog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();

        progressDoalog = new ProgressDialog(MainActivity.this);
        progressDoalog.setMessage("Loading....");
        progressDoalog.show();

        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();

        Timber.plant(new Timber.DebugTree());

        HttpLoggingInterceptor httpLoggingInterceptor = new
                HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(@NonNull String message) {
                Timber.i(message);
            }
        });

        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okHttpClient = new OkHttpClient()
                .newBuilder()
                .addInterceptor(httpLoggingInterceptor)
                .build();

        retrofit = new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl("https://gateway.marvel.com/v1/public/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        populateComics();

    }

    private void initViews() {
        recyclerView = findViewById(R.id.customRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void populateComics() {
        Call<ComicDataContainer> comicDataContainerCall = getMarvelService().getAllComics(10) ;
        comicDataContainerCall.enqueue(new Callback<ComicDataContainer>() {
            @Override
            public void onResponse(Call<ComicDataContainer> call, Response<ComicDataContainer> response) {
                if(response.isSuccessful()) {
                    progressDoalog.dismiss();
                    generateDataList(response.body().getResults());

                }
            }

            @Override
            public void onFailure(Call<ComicDataContainer> call, Throwable t) {
                progressDoalog.dismiss();
                Timber.i(t.getMessage());
            }
        });
    }

    public MarvelService getMarvelService(){
        return retrofit.create(MarvelService.class);
    }

    private void generateDataList(List<Comic> comicList) {
        recyclerView = findViewById(R.id.customRecyclerView);
        adapter = new CustomAdapter(this,comicList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

}