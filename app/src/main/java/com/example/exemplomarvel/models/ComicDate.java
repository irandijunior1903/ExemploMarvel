package com.example.exemplomarvel.models;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class ComicDate {
    @SerializedName("type")
    private String type;
    @SerializedName("date")
    private Date date;

    public ComicDate(String type, Date date) {
        this.type = type;
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
