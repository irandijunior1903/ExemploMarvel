package com.example.exemplomarvel.module;

import android.content.Context;

import com.example.exemplomarvel.activity.MainActivity;
import com.example.exemplomarvel.scope.MarvelActivityScope;

import javax.inject.Inject;

import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {
    private MainActivity mainActivity;

    public Context context;

    public ActivityModule(MainActivity mainActivity){
        this.mainActivity = mainActivity;
        context = mainActivity;
    }

    @Provides
    @MarvelActivityScope
    public MainActivity getMainActivity(){
        return mainActivity;
    }

    @Provides
    @MarvelActivityScope
    @MarvelActivityContext
    public Context getContext(){
        return context;
    }
}
