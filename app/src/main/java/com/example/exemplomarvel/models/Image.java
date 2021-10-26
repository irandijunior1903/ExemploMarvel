package com.example.exemplomarvel.models;

import com.google.gson.annotations.SerializedName;

public class Image {
    @SerializedName("path")
    private String path;
    @SerializedName("extension")
    private String extension;

    public Image(String path, String extension) {
        this.path = path;
        this.extension = extension;
    }

    public String getPath() {
        return path;
    }

    public String getExtension() {
        return extension;
    }

}
