package com.example.exemplomarvel.component;

import com.example.exemplomarvel.module.MarvelModule;
import com.example.exemplomarvel.network.MarvelService;
import com.example.exemplomarvel.scope.MarvelApplicationScope;

import dagger.Component;

@MarvelApplicationScope
@Component(modules = MarvelModule.class)
public interface MarvelComponent {
    MarvelService getMarvelService();
}
