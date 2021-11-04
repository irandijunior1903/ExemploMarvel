package com.example.exemplomarvel.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Comic implements Parcelable {
    @SerializedName("title")
    private String title;
    @SerializedName("description")
    private String description;
    @SerializedName("prices")
    private List<ComicPrice> prices;
    @SerializedName("thumbnail")
    private Image thumbnail;

    private boolean raro = false;

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

    public boolean isRaro() {
        return raro;
    }

    public void setRaro(boolean raro) {
        this.raro = true;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.title);
        dest.writeString(this.description);
        dest.writeTypedList(this.prices);
        dest.writeParcelable(this.thumbnail, flags);
        dest.writeByte(this.raro ? (byte) 1 : (byte) 0);
    }

    public void readFromParcel(Parcel source) {
        this.title = source.readString();
        this.description = source.readString();
        this.prices = source.createTypedArrayList(ComicPrice.CREATOR);
        this.thumbnail = source.readParcelable(Image.class.getClassLoader());
        this.raro = source.readByte() != 0;
    }

    public Comic() {
    }

    protected Comic(Parcel in) {
        this.title = in.readString();
        this.description = in.readString();
        this.prices = in.createTypedArrayList(ComicPrice.CREATOR);
        this.thumbnail = in.readParcelable(Image.class.getClassLoader());
        this.raro = in.readByte() != 0;
    }

    public static final Creator<Comic> CREATOR = new Creator<Comic>() {
        @Override
        public Comic createFromParcel(Parcel source) {
            return new Comic(source);
        }

        @Override
        public Comic[] newArray(int size) {
            return new Comic[size];
        }
    };
}
