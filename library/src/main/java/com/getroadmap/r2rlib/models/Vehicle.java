package com.getroadmap.r2rlib.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.getroadmap.r2rlib.enums.VehicleKind;

/**
 * Created by jan on 11/07/16.
 *
 * https://www.rome2rio.com/documentation/search#Vehicle
 */

public class Vehicle implements Parcelable {
    /*
    name 	string 	Vehicle display name
    kind 	string 	Vehicle kind [1]

    [1] The following kinds are supported: unknown, plane, helicopter, car, bus, taxi,
     rideshare, shuttle, towncar, train, tram, cablecar, subway, ferry,
      foot, animal, bicycle.
      Please note that this list will likely change in future revisions.
     */


    private String name;
    private String kind;

    public Vehicle() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKind() {
        return kind;
    }

    public VehicleKind getVehicleKind(){
        return VehicleKind.fromString(getKind());
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    protected Vehicle(Parcel in) {
        name = in.readString();
        kind = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(kind);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Vehicle> CREATOR = new Parcelable.Creator<Vehicle>() {
        @Override
        public Vehicle createFromParcel(Parcel in) {
            return new Vehicle(in);
        }

        @Override
        public Vehicle[] newArray(int size) {
            return new Vehicle[size];
        }
    };

    @Override
    public String toString() {
        return "Vehicle{" +
                "name='" + name + '\'' +
                ", kind='" + kind + '\'' +
                '}';
    }
}