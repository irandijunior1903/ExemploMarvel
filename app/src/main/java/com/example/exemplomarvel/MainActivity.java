package com.example.exemplomarvel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;

import android.widget.Toast;

import com.example.exemplomarvel.adapter.CustomAdapter;
import com.example.exemplomarvel.models.Comic;
import com.example.exemplomarvel.models.ComicDataWrapper;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    CustomAdapter adapter;
    RecyclerView recyclerView;
    ProgressDialog progressDoalog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressDoalog = new ProgressDialog(MainActivity.this);
        progressDoalog.setMessage("Loading....");
        progressDoalog.show();

        MarvelService service = RetrofitClientInstance.getRetrofitInstance().create(MarvelService.class);
        Call<ComicDataWrapper> call = service.getAllComics("1", "f037ab6e62e83f9bbd49c158cbb0b541", "4dd1d9efdd156d320064a627542547c9", "10") ;
        call.enqueue(new Callback<ComicDataWrapper>() {
            @Override
            public void onResponse(Call<ComicDataWrapper> call, Response<ComicDataWrapper> response) {
                progressDoalog.dismiss();
                generateDataList(response.body().getData().getResults());
            }

            @Override
            public void onFailure(Call<ComicDataWrapper> call, Throwable t) {
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