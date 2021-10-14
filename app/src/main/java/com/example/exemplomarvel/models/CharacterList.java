package com.example.exemplomarvel.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CharacterList {
    @SerializedName("available")
    private int available;
    @SerializedName("returned")
    private int returned;
    @SerializedName("collectionURI")
    private String collectionURI;
    @SerializedName("items")
    private List<CharacterSummary> items;

    public CharacterList(int available, int returned, String collectionURI, List<CharacterSummary> items) {
        this.available = available;
        this.returned = returned;
        this.collectionURI = collectionURI;
        this.items = items;
    }

    public int getAvailable() {
        return available;
    }

    public void setAvailable(int available) {
        this.available = available;
    }

    public int getReturned() {
        return returned;
    }

    public void setReturned(int returned) {
        this.returned = returned;
    }

    public String getCollectionURI() {
        return collectionURI;
    }

    public void setCollectionURI(String collectionURI) {
        this.collectionURI = collectionURI;
    }

    public List<CharacterSummary> getItems() {
        return items;
    }

    public void setItems(List<CharacterSummary> items) {
        this.items = items;
    }
}
