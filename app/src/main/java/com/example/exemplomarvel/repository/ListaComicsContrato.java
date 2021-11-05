package com.example.exemplomarvel.repository;

import com.example.exemplomarvel.models.Comic;

import java.util.List;

public interface ListaComicsContrato {
    interface ListaComicsView{
        void exibirComics(List<Comic> comics);
        void exibirErro();

    }
    interface ListaComicsPresenter{
        void recuperaComics();
        void destruirView();
    }
}
