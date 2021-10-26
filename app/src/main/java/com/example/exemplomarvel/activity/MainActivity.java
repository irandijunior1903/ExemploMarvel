package com.example.exemplomarvel.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.Toast;

import com.example.exemplomarvel.ListaComicsContrato;
import com.example.exemplomarvel.ListaComicsPresenter;
import com.example.exemplomarvel.R;
import com.example.exemplomarvel.models.Comic;
import com.example.exemplomarvel.network.RetrofitClientInstance;
import com.example.exemplomarvel.adapter.CustomAdapter;

import com.example.exemplomarvel.models.ComicDataWrapper;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements ListaComicsContrato.ListaComicsView {

    private CustomAdapter adapter;
    private RecyclerView recyclerView;
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

    private void configuraAdapter(){
        recyclerView = findViewById(R.id.recyclerfilmes);
        adapter = new CustomAdapter();
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
}