package com.example.exemplomarvel.component;

import android.content.Context;

import com.example.exemplomarvel.application.MarvelApplication;
import com.example.exemplomarvel.module.ContextModule;
import com.example.exemplomarvel.module.MarvelApplicationContext;
import com.example.exemplomarvel.module.MarvelModule;
import com.example.exemplomarvel.network.MarvelService;
import com.example.exemplomarvel.scope.MarvelApplicationScope;

import dagger.Component;

@MarvelApplicationScope
@Component(modules = {ContextModule.class, MarvelModule.class})
public interface MarvelComponent {
    MarvelService getMarvelService();

    @MarvelApplicationContext
    Context getContext();

    void injectApplication(MarvelApplication marvelApplication);
}
