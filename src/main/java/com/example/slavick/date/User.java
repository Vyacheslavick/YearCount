package com.example.slavick.date;

import android.os.Parcel;
import android.os.Parcelable;

public class User implements Parcelable {
    String day;
    String month;
    String year;

    public User(String day, String month, String year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    protected User(Parcel in) {
        day = in.readString();
        month = in.readString();
        year = in.readString();
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(day);
        dest.writeString(month);
        dest.writeString(year);
    }
}
