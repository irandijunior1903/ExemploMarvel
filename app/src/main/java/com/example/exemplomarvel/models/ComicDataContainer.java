package com.example.exemplomarvel.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ComicDataContainer {
    @SerializedName("results")
    private List<Comic> results;

    public ComicDataContainer(List<Comic> results) {
        this.results = results;
    }

    public List<Comic> getResults() {
        return results;
    }

}
