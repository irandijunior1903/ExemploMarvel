package com.example.exemplomarvel.presenter;

import com.example.exemplomarvel.models.Comic;
import com.example.exemplomarvel.models.ComicDataWrapper;
import com.example.exemplomarvel.network.RetrofitClientInstance;

import java.util.Collections;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListaComicsPresenter implements ListaComicsContrato.ListaComicsPresenter{

    private ListaComicsContrato.ListaComicsView view;

    public ListaComicsPresenter(ListaComicsContrato.ListaComicsView view){
        this.view = view;
    }

    @Override
    public void recuperaComics() {
        RetrofitClientInstance.getInstance()
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
