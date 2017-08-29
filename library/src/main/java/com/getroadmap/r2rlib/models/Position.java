package com.getroadmap.r2rlib.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 *
 */
public class Position implements Parcelable {

    private double mLatitude;
    private double mLongitude;

    public Position(double lat, double lon) {
        if(-180.0D <= lon && lon < 180.0D) {
            this.mLongitude = lon;
        } else {
            this.mLongitude = ((lon - 180.0D) % 360.0D + 360.0D) % 360.0D - 180.0D;
        }

        this.mLatitude = Math.max(-90.0D, Math.min(90.0D, lat));
    }

    public Position(android.location.Location loc) {
        mLatitude = loc.getLatitude();
        mLongitude = loc.getLongitude();
    }

    public double getLatitude() {
        return mLatitude;
    }

    public void setLatitude(double latitude) {
        mLatitude = latitude;
    }

    public double getLongitude() {
        return mLongitude;
    }

    public void setLongitude(double longitude) {
        mLongitude = longitude;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeDouble(this.mLatitude);
        dest.writeDouble(this.mLongitude);
    }

    protected Position(Parcel in) {
        this.mLatitude = in.readDouble();
        this.mLongitude = in.readDouble();
    }

    public static final Parcelable.Creator<Position> CREATOR = new Parcelable.Creator<Position>() {
        public Position createFromParcel(Parcel source) {
            return new Position(source);
        }

        public Position[] newArray(int size) {
            return new Position[size];
        }
    };

    @Override
    public String toString() {
        return "Position{" +
                "mLatitude=" + mLatitude +
                ", mLongitude=" + mLongitude +
                '}';
    }
}
