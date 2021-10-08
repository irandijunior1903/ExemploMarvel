package com.example.exemplomarvel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.Toast;

import com.example.exemplomarvel.adapter.CustomAdapter;
import com.example.exemplomarvel.models.Comic;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private CustomAdapter adapter;
    private RecyclerView recyclerView;
    ProgressDialog progressDoalog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressDoalog = new ProgressDialog(MainActivity.this);
        progressDoalog.setMessage("Loading....");
        progressDoalog.show();

        /*Create handle for the RetrofitInstance interface*/
        MarvelService service = RetrofitClientInstance.getRetrofitInstance().create(MarvelService.class);
        Call<List<Comic>> call = service.getAllComics();
        call.enqueue(new Callback<List<Comic>>() {
            @Override
            public void onResponse(Call<List<Comic>> call, Response<List<Comic>> response) {
                progressDoalog.dismiss();
                generateDataList(response.body());
            }

            @Override
            public void onFailure(Call<List<Comic>> call, Throwable t) {
                progressDoalog.dismiss();
                Toast.makeText(MainActivity.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    /*Method to generate List of data using RecyclerView with custom adapter*/
    private void generateDataList(List<Comic> comicList) {
        recyclerView = findViewById(R.id.customRecyclerView);
        adapter = new CustomAdapter(this,comicList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

}