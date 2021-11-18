package com.example.exemplomarvel.repository;

import com.example.exemplomarvel.models.Comic;

import java.util.List;

public interface ListaComicsContrato {
    interface ListaComicsView{
        void showData(List<Comic> comics);
        void showError();

    }
    interface ListaComicsRepository{
        void loadData();
        void viewDestroy();
    }
}
