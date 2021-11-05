package com.example.exemplomarvel.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class ComicPrice implements Parcelable {
    @SerializedName("type")
    private String type;
    @SerializedName("price")
    private float price;

    public String getType() {
        return type;
    }

    public float getPrice() {
        return price;
    }

    public float setPrice(float price) {
        this.price = price;
        return price;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.type);
        dest.writeFloat(this.price);
    }


    protected ComicPrice(Parcel in) {
        this.type = in.readString();
        this.price = in.readFloat();
    }

    public static final Parcelable.Creator<ComicPrice> CREATOR = new Parcelable.Creator<ComicPrice>() {
        @Override
        public ComicPrice createFromParcel(Parcel source) {
            return new ComicPrice(source);
        }

        @Override
        public ComicPrice[] newArray(int size) {
            return new ComicPrice[size];
        }
    };
}
