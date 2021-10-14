package com.example.exemplomarvel.models;

import com.google.gson.annotations.SerializedName;

public class ComicSummary {
    @SerializedName("resourceURI")
    private String resourceURI;
    @SerializedName("name")
    private String name;

    public ComicSummary(String resourceURI, String name) {
        this.resourceURI = resourceURI;
        this.name = name;
    }
}
