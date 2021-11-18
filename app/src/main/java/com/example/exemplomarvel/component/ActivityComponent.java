package com.example.exemplomarvel.component;

import android.content.Context;

import com.example.exemplomarvel.activity.MainActivity;
import com.example.exemplomarvel.module.ActivityMvpModule;
import com.example.exemplomarvel.module.AdapterModule;
import com.example.exemplomarvel.module.MarvelActivityContext;
import com.example.exemplomarvel.scope.MarvelActivityScope;

import dagger.Component;

@MarvelActivityScope
@Component(modules = {AdapterModule.class, ActivityMvpModule.class}, dependencies = MarvelComponent.class)
public interface ActivityComponent {

    @MarvelActivityContext
    Context getContext();

    void injectMainActivity(MainActivity mainActivity);
}
