package com.example.exemplomarvel.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Comic {
    @SerializedName("title")
    private String title;
    @SerializedName("description")
    private String description;
    @SerializedName("prices")
    private List<ComicPrice> prices;
    @SerializedName("thumbnail")
    private Image thumbnail;

    public Comic(String title, String description, List<ComicPrice> prices, Image thumbnail) {
        this.title = title;
        this.description = description;
        this.prices = prices;
        this.thumbnail = thumbnail;

    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public List<ComicPrice> getPrices() {
        return prices;
    }

    public Image getThumbnail() {
        return thumbnail;
    }
}
