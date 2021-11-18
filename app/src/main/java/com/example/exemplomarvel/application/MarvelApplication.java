package com.example.exemplomarvel.application;

import android.app.Application;


import com.example.exemplomarvel.activity.MainActivity;
import com.example.exemplomarvel.component.DaggerMarvelComponent;
import com.example.exemplomarvel.component.MarvelComponent;
import com.example.exemplomarvel.module.ContextModule;

public class MarvelApplication extends Application {
    MarvelComponent marvelComponent;

    @Override
    public void onCreate(){
        super.onCreate();

       marvelComponent = DaggerMarvelComponent.builder().contextModule(new ContextModule(this)).build();
       marvelComponent.injectApplication(this);
    }

    public static MarvelApplication get(MainActivity activity){
        return (MarvelApplication) activity.getApplicationContext();
    }

    public MarvelComponent getMarvelComponent(){
        return marvelComponent;
    }
}
