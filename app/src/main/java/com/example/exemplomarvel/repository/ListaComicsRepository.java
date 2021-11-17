package com.example.exemplomarvel.repository;

import com.example.exemplomarvel.component.DaggerMarvelComponent;
import com.example.exemplomarvel.component.MarvelComponent;
import com.example.exemplomarvel.models.Comic;
import com.example.exemplomarvel.models.ComicDataWrapper;
import com.example.exemplomarvel.network.MarvelService;

import java.util.Collections;
import java.util.List;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListaComicsRepository implements ListaComicsContrato.ListaComicsRepository{

    private ListaComicsContrato.ListaComicsView view;
    MarvelService marvelService;
    public ListaComicsRepository(ListaComicsContrato.ListaComicsView view){
        this.view = view;
    }

    @Override
    public void recuperaComics() {
        MarvelComponent marvelComponent = DaggerMarvelComponent.builder().build();
        marvelService = marvelComponent.getMarvelService();
        marvelService
                .getAllComics("1", "f037ab6e62e83f9bbd49c158cbb0b541", "4dd1d9efdd156d320064a627542547c9")
                .enqueue(new Callback<ComicDataWrapper>() {
                    @Override
                    public void onResponse(Call<ComicDataWrapper> call, Response<ComicDataWrapper> response) {
                        if(response.isSuccessful()){
                            List<Comic> comicList = response.body().getData().getResults();
                            List<Comic> novaLista = alteraRaridade(comicList);
                            Collections.shuffle(novaLista);
                            view.exibirComics(novaLista);

                        }
                    }

                    @Override
                    public void onFailure(Call<ComicDataWrapper> call, Throwable t) {
                        view.exibirErro();
                    }
                });
    }

    @Override
    public void destruirView() {
        this.view = null;
    }

    public List<Comic> alteraRaridade(List<Comic> comics){
        Collections.shuffle(comics);
        for(int i=0; i<=comics.size()-1; i++){
            if(comics.get(i).isRaro()==false && i <=1){
                comics.get(i).setRaro(true);
                break;
            }
        }
        return comics;
    }


}
