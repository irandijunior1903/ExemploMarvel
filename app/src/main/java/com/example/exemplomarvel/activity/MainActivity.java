package com.example.exemplomarvel.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.exemplomarvel.application.MarvelApplication;
import com.example.exemplomarvel.component.ActivityComponent;
import com.example.exemplomarvel.component.DaggerActivityComponent;
import com.example.exemplomarvel.component.MarvelComponent;
import com.example.exemplomarvel.module.ActivityModule;
import com.example.exemplomarvel.module.ActivityMvpModule;
import com.example.exemplomarvel.module.MarvelActivityContext;
import com.example.exemplomarvel.module.MarvelApplicationContext;
import com.example.exemplomarvel.repository.ListaComicsContrato;
import com.example.exemplomarvel.repository.ListaComicsRepository;
import com.example.exemplomarvel.R;
import com.example.exemplomarvel.models.Comic;
import com.example.exemplomarvel.adapter.CustomAdapter;

import java.util.List;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements ListaComicsContrato.ListaComicsView,
            CustomAdapter.ItemComicClickListener{

    ProgressDialog progressDoalog;
    ActivityComponent activityComponent;

    @Inject
    CustomAdapter adapter;

    @Inject
    @MarvelApplicationContext
    public Context context;

    @Inject
    @MarvelActivityContext
    public Context activityContext;

    @Inject
    ListaComicsRepository repository;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        MarvelComponent marvelComponent = MarvelApplication.get(MainActivity.this).getMarvelComponent();
        activityComponent = DaggerActivityComponent.builder()
                .activityModule(new ActivityModule(this))
                .activityMvpModule(new ActivityMvpModule(this))
                .marvelComponent(marvelComponent)
                .build();

        activityComponent.injectMainActivity(this);

        repository.loadData();

        progressDoalog = new ProgressDialog(MainActivity.this);
        progressDoalog.setMessage("Loading....");
        progressDoalog.show();

        configureAdapter();



    }

    public void configureAdapter(){
        RecyclerView recyclerView = findViewById(R.id.recyclercomics);
        adapter = new CustomAdapter(this);
        RecyclerView.LayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
    }


    @Override
    public void showData(List<Comic> comics) {
        adapter.setComics(comics);
        progressDoalog.dismiss();

    }

    @Override
    public void showError(){
        Toast.makeText(MainActivity.this, "Erro ao carregar os dados!", Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        repository.viewDestroy();

    }

    @Override
    public void onClickListener(Comic comic) {
        Intent intent = new Intent(MainActivity.this, SegundaActivity.class);
        intent.putExtra("Comic", comic);
        startActivity(intent);
    }
}