package com.getroadmap.r2rlib.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by jan on 08/07/16.
 * "icon": implements Parcelable {
 *      "url": "/logos/trains/nl.png",
 *      "x": 0,
 *      "y": 0,
 *      "w": 27,
 *      "h": 23
 * }
 */

public class Icon implements Parcelable {
    private String url;
    private int x;
    private int y;
    private int w;
    private int h;

    public Icon() {
    }

    public String getUrl(){
        return url;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return w;
    }

    public int getHeight() {
        return h;
    }

    protected Icon(Parcel in) {
        url = in.readString();
        x = in.readInt();
        y = in.readInt();
        w = in.readInt();
        h = in.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(url);
        dest.writeInt(x);
        dest.writeInt(y);
        dest.writeInt(w);
        dest.writeInt(h);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Icon> CREATOR = new Parcelable.Creator<Icon>() {
        @Override
        public Icon createFromParcel(Parcel in) {
            return new Icon(in);
        }

        @Override
        public Icon[] newArray(int size) {
            return new Icon[size];
        }
    };

    @Override
    public String toString() {
        return "Icon{" +
                "url='" + url + '\'' +
                ", x=" + x +
                ", y=" + y +
                ", w=" + w +
                ", h=" + h +
                '}';
    }
}