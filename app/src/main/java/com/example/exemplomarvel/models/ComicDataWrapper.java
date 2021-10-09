package com.example.exemplomarvel.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ComicDataWrapper {
    @SerializedName("data")
    @Expose
    private ComicDataContainer data;

    public ComicDataWrapper(ComicDataContainer data) {
        this.data = data;
    }

    public ComicDataContainer getData() {
        return data;
    }

    public void setData(ComicDataContainer data) {
        this.data = data;
    }
}
