package com.rshealth.viewpagerdemo;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by 百强 on 2017/3/15.
 */

public class HomeModel implements Parcelable {
    public String name;

    public String name_en;

    public HomeModel() {
    }

    protected HomeModel(Parcel in) {
        name = in.readString();
        name_en = in.readString();
    }

    public static final Creator<HomeModel> CREATOR = new Creator<HomeModel>() {
        @Override
        public HomeModel createFromParcel(Parcel in) {
            return new HomeModel(in);
        }

        @Override
        public HomeModel[] newArray(int size) {
            return new HomeModel[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(name_en);
    }

    @Override
    public String toString() {
        return "HomeModel{" +
                "name='" + name + '\'' +
                ", name_en='" + name_en + '\'' +
                '}';
    }
}
