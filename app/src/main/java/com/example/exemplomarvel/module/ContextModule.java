package com.example.exemplomarvel.module;

import android.content.Context;

import com.example.exemplomarvel.scope.MarvelApplicationScope;

import dagger.Module;
import dagger.Provides;

@Module
public class ContextModule {
    Context context;

    public ContextModule(Context context){
        this.context = context;
    }

    @Provides
    @MarvelApplicationScope
    @MarvelApplicationContext
    public Context context(){
        return context;
    }


}
