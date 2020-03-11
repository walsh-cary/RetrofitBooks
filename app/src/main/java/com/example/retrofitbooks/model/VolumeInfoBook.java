package com.example.retrofitbooks.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public class VolumeInfoBook implements Parcelable {
    public String title;
    public List<String> authors;
    public Float averageRating;
    public ImageBook imageLinks;
    public String previewLink;

    public VolumeInfoBook(){}

    protected VolumeInfoBook(Parcel in) {
        title = in.readString();
        authors = in.createStringArrayList();
        if (in.readByte() == 0) {
            averageRating = null;
        } else {
            averageRating = in.readFloat();
        }
        imageLinks = in.readParcelable(ImageBook.class.getClassLoader());
        previewLink = in.readString();
    }

    public static final Creator<VolumeInfoBook> CREATOR = new Creator<VolumeInfoBook>() {
        @Override
        public VolumeInfoBook createFromParcel(Parcel in) {
            return new VolumeInfoBook(in);
        }

        @Override
        public VolumeInfoBook[] newArray(int size) {
            return new VolumeInfoBook[size];
        }
    };

    public String authorsToString() {
        StringBuilder builder = new StringBuilder();
        for (String author :
                authors) {
            builder.append("Name: " + author + "\n");
        }
        return builder.toString();
    }

    public String averageRatingToString() {
        return averageRating.toString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeStringList(authors);
        if (averageRating == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeFloat(averageRating);
        }
        dest.writeParcelable(imageLinks, flags);
        dest.writeString(previewLink);
    }
}
