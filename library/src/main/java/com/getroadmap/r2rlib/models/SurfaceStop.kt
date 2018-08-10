package com.getroadmap.r2rlib.models

import android.os.Parcel
import android.os.Parcelable

/**
 * Created by jan on 11/07/16.
 *
 *
 * https://www.rome2rio.com/documentation/search#SurfaceStop
 */

/**
 * place 	            integer 	Place (index into places array)
 * transitDuration 	float 	Estimated duration spent in transit (in minutes)
 * stopDuration 	    float 	Estimated duration spent waiting at stop before departing (in minutes)
 */
data class SurfaceStop(val place: Int?,
                       val transitDuration: Float?,
                       val stopDuration: Float?) : Parcelable {

    constructor(parcel: Parcel) : this(
            parcel.readValue(Int::class.java.classLoader) as? Int,
            parcel.readValue(Float::class.java.classLoader) as? Float,
            parcel.readValue(Float::class.java.classLoader) as? Float) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(place)
        parcel.writeValue(transitDuration)
        parcel.writeValue(stopDuration)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<SurfaceStop> {
        override fun createFromParcel(parcel: Parcel): SurfaceStop {
            return SurfaceStop(parcel)
        }

        override fun newArray(size: Int): Array<SurfaceStop?> {
            return arrayOfNulls(size)
        }
    }

}