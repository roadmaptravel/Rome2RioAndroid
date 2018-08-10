package com.getroadmap.r2rlib.models

import android.os.Parcel
import android.os.Parcelable

import com.getroadmap.r2rlib.enums.VehicleKind

/**
 * Created by jan on 11/07/16.
 *
 * https://www.rome2rio.com/documentation/search#Vehicle
 */

/*
    name 	string 	Vehicle display name
    kind 	string 	Vehicle kind [1]

    [1] The following kinds are supported: unknown, plane, helicopter, car, bus, taxi,
     rideshare, shuttle, towncar, train, tram, cablecar, subway, ferry,
      foot, animal, bicycle.
      Please note that this list will likely change in future revisions.
     */
data class Vehicle(val name: String?,
                   val kind: String?) : Parcelable {

    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(kind)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Vehicle> {
        override fun createFromParcel(parcel: Parcel): Vehicle {
            return Vehicle(parcel)
        }

        override fun newArray(size: Int): Array<Vehicle?> {
            return arrayOfNulls(size)
        }
    }


}