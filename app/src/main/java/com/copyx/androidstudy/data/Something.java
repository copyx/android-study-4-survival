package com.copyx.androidstudy.data;

import android.os.Parcel;
import android.os.Parcelable;

public class Something implements Parcelable {

    int number;
    String message;

    public Something(int number, String message) {
        this.number = number;
        this.message = message;
    }

    public Something(Parcel source) {
        this.number = source.readInt();
        this.message = source.readString();
    }

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        @Override
        public Object createFromParcel(Parcel source) {
            return new Something(source);
        }

        @Override
        public Something[] newArray(int size) {
            return new Something[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(number);
        dest.writeString(message);
    }

    public int getNumber() {
        return number;
    }

    public Something setNumber(int number) {
        this.number = number;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public Something setMessage(String message) {
        this.message = message;
        return this;
    }
}
