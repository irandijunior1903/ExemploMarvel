package com.example.exemplomarvel.models;

import com.google.gson.annotations.SerializedName;

public class ComicPrice {
    @SerializedName("type")
    private String type;
    @SerializedName("price")
    private float price;

    public ComicPrice(String type, float price) {
        this.type = type;
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public float getPrice() {
        return price;
    }

}
