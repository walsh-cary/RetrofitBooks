package com.example.retrofitbooks.model;

import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;

public class BookItem implements Parcelable {
    public VolumeInfoBook volumeInfo;

    public BookItem(){}

    protected BookItem(Parcel in) {
        volumeInfo = in.readParcelable(VolumeInfoBook.class.getClassLoader());
    }

    public static final Creator<BookItem> CREATOR = new Creator<BookItem>() {
        @Override
        public BookItem createFromParcel(Parcel in) {
            return new BookItem(in);
        }

        @Override
        public BookItem[] newArray(int size) {
            return new BookItem[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(volumeInfo, flags);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            dest.writeTypedObject(volumeInfo, flags);
        }
    }
}
