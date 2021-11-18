package com.example.exemplomarvel.repository;

import androidx.annotation.NonNull;


import com.example.exemplomarvel.models.Comic;
import com.example.exemplomarvel.models.ComicDataWrapper;
import com.example.exemplomarvel.network.MarvelService;

import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class ListaComicsRepository implements ListaComicsContrato.ListaComicsRepository{

    private ListaComicsContrato.ListaComicsView view;
    MarvelService marvelService;

    @Inject
    public ListaComicsRepository(MarvelService marvelService, ListaComicsContrato.ListaComicsView view){
        this.marvelService = marvelService;
        this.view = view;
    }

    @Override
    public void loadData() {
        Observable<ComicDataWrapper> observable =
        marvelService.getAllComics("1", "f037ab6e62e83f9bbd49c158cbb0b541", "4dd1d9efdd156d320064a627542547c9");
        observable
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ComicDataWrapper>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull ComicDataWrapper comicDataWrapper) {
                        List<Comic> comicList = comicDataWrapper.getData().getResults();
                        List<Comic> novaLista = alteraRaridade(comicList);
                        Collections.shuffle(novaLista);
                        view.showData(novaLista);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });


    }
    @Override
    public void viewDestroy() {
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
