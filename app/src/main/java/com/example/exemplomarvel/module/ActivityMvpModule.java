package com.example.exemplomarvel.module;

import com.example.exemplomarvel.repository.ListaComicsContrato;
import com.example.exemplomarvel.scope.MarvelActivityScope;

import dagger.Module;
import dagger.Provides;

@Module
public class ActivityMvpModule {
    private final ListaComicsContrato.ListaComicsView listaComicsView;

    public ActivityMvpModule(ListaComicsContrato.ListaComicsView listaComicsView){
        this.listaComicsView = listaComicsView;
    }

    @Provides
    @MarvelActivityScope
    ListaComicsContrato.ListaComicsView getListaComicsView(){
        return listaComicsView;
    }
}
