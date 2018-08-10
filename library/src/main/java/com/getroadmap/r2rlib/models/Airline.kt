package com.getroadmap.r2rlib.models

import android.os.Parcel
import android.os.Parcelable

/**
 * Created by Glenn on 09-07-15.
 *
 * https://www.rome2rio.com/documentation/search#Airline
 * class for api v1.4
 */

/**
 * code 	string 	Airline code (IATA)
 * name 	string 	Display name
 * url 	string 	Airline URL (optional)
 * icon 	Icon 	Airline icon (optional)
 */
data class Airline(val code: String?,
                   val name: String?,
                   val url: String?,
                   val icon: Icon?) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readParcelable(Icon::class.java.classLoader)) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(code)
        parcel.writeString(name)
        parcel.writeString(url)
        parcel.writeParcelable(icon, flags)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Airline> {
        override fun createFromParcel(parcel: Parcel): Airline {
            return Airline(parcel)
        }

        override fun newArray(size: Int): Array<Airline?> {
            return arrayOfNulls(size)
        }
    }


}