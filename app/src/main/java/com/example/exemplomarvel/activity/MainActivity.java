package com.example.exemplomarvel.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.exemplomarvel.presenter.ListaComicsContrato;
import com.example.exemplomarvel.presenter.ListaComicsPresenter;
import com.example.exemplomarvel.R;
import com.example.exemplomarvel.models.Comic;
import com.example.exemplomarvel.adapter.CustomAdapter;

import java.util.List;

public class MainActivity extends AppCompatActivity implements ListaComicsContrato.ListaComicsView,
            CustomAdapter.ItemComicClickListener{

    private CustomAdapter adapter;
    private ListaComicsContrato.ListaComicsPresenter presenter;
    ProgressDialog progressDoalog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        configuraAdapter();

        presenter = new ListaComicsPresenter(this);
        presenter.recuperaComics();

        progressDoalog = new ProgressDialog(MainActivity.this);
        progressDoalog.setMessage("Loading....");
        progressDoalog.show();


    }

    public void configuraAdapter(){
        RecyclerView recyclerView = findViewById(R.id.recyclercomics);
        adapter = new CustomAdapter(this);
        RecyclerView.LayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);

        }

    @Override
    public void exibirComics(List<Comic> comics) {
        adapter.setComics(comics);
        progressDoalog.dismiss();
    }

    @Override
    public void exibirErro(){
        Toast.makeText(MainActivity.this, "Erro ao carregar os dados!", Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        presenter.destruirView();
    }

    @Override
    public void OnItemClick(Comic comic) {
        Intent intent = new Intent(this, SegundaActivity.class);
        intent.putExtra("Comic", comic);
        startActivity(intent);
    }
}