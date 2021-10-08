package com.example.exemplomarvel.models;

import com.google.gson.annotations.SerializedName;

public class Comic {
    @SerializedName("title")
    public String title;
    @SerializedName("description")
    public String description;
    @SerializedName("thumbnail")
    public String thumbnail;

    public Comic(String title, String description, String thumbnail) {
        this.title = title;
        this.description = description;
        this.thumbnail = thumbnail;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }
}
