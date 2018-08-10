package com.getroadmap.r2rlib.models

import android.os.Parcel
import android.os.Parcelable

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by jan on 11/07/16.
 */

/**
 * airline 	integer 	Airline (index into airlines array)
 * flight 	string 	    Flight number
 */
data class AirCodeshare(@SerializedName("airline")
                        @Expose
                        val airline: Int?,
                        @SerializedName("flight")
                        @Expose
                        val flight: String?) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readValue(Int::class.java.classLoader) as? Int,
            parcel.readString()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(airline)
        parcel.writeString(flight)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<AirCodeshare> {
        override fun createFromParcel(parcel: Parcel): AirCodeshare {
            return AirCodeshare(parcel)
        }

        override fun newArray(size: Int): Array<AirCodeshare?> {
            return arrayOfNulls(size)
        }
    }

}