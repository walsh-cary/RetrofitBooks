package com.example.retrofitbooks.model;

import android.os.Parcel;
import android.os.Parcelable;

public class ImageBook implements Parcelable {
    public String thumbnail;

    public ImageBook(){}

    protected ImageBook(Parcel in) {
        thumbnail = in.readString();
    }

    public static final Creator<ImageBook> CREATOR = new Creator<ImageBook>() {
        @Override
        public ImageBook createFromParcel(Parcel in) {
            return new ImageBook(in);
        }

        @Override
        public ImageBook[] newArray(int size) {
            return new ImageBook[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(thumbnail);
    }
}
