package com.example.exemplomarvel.module;

import com.example.exemplomarvel.activity.MainActivity;
import com.example.exemplomarvel.adapter.CustomAdapter;
import com.example.exemplomarvel.scope.MarvelActivityScope;


import dagger.Module;
import dagger.Provides;

@Module(includes = {ActivityModule.class})
public class AdapterModule {


    @Provides
    @MarvelActivityScope
    public CustomAdapter getCustomAdapter(CustomAdapter.ItemComicClickListener itemComicClickListener){
        return new CustomAdapter(itemComicClickListener);
    }

    @Provides
    @MarvelActivityScope
    public CustomAdapter.ItemComicClickListener getComicClickListener(MainActivity mainActivity){
        return mainActivity;
    }

}
