package com.getroadmap.r2rlib.models

import android.os.Parcel
import android.os.Parcelable

import java.util.ArrayList

/**
 * https://www.rome2rio.com/documentation/search#Route
 */

/**
 * name 	                string 	            Route display name
 * depPlace 	            integer 	        Departure place (index into places array)
 * arrPlace 	            integer 	        Arrival place (index into places array)
 * distance 	            float 	            Estimated total distance (in km)
 * totalDuration 	        float 	            Estimated total duration (in minutes, includes transfers)
 * totalTransitDuration 	float 	            Estimated total duration spent in transit (in minutes)
 * totalTransferDuration 	float 	            Estimated total duration spent waiting for transfers (in minutes)
 * indicativePrices 	    IndicativePrice[] 	Array of indicative prices (optional)
 * segments 	            Segment[] 	        Array of segments
 * alternatives 	        Alternative[] 	    Array of alternative segments (optional)
 */
data class Route(val name: String?,
                 val depPlace: Int?,
                 val arrPlace: Int?,
                 val distance: Float?,
                 val totalDuration: Float?,
                 val totalTransitDuration: Float?,
                 val totalTransferDuration: Float?,
                 val indicativePrices: List<IndicativePrice>?,
                 val segments: List<Segment>?,
                 val alternatives: List<Alternative>?) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readValue(Int::class.java.classLoader) as? Int,
            parcel.readValue(Int::class.java.classLoader) as? Int,
            parcel.readValue(Float::class.java.classLoader) as? Float,
            parcel.readValue(Float::class.java.classLoader) as? Float,
            parcel.readValue(Float::class.java.classLoader) as? Float,
            parcel.readValue(Float::class.java.classLoader) as? Float,
            parcel.createTypedArrayList(IndicativePrice),
            parcel.createTypedArrayList(Segment),
            parcel.createTypedArrayList(Alternative)) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeValue(depPlace)
        parcel.writeValue(arrPlace)
        parcel.writeValue(distance)
        parcel.writeValue(totalDuration)
        parcel.writeValue(totalTransitDuration)
        parcel.writeValue(totalTransferDuration)
        parcel.writeTypedList(indicativePrices)
        parcel.writeTypedList(segments)
        parcel.writeTypedList(alternatives)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Route> {
        override fun createFromParcel(parcel: Parcel): Route {
            return Route(parcel)
        }

        override fun newArray(size: Int): Array<Route?> {
            return arrayOfNulls(size)
        }
    }


}