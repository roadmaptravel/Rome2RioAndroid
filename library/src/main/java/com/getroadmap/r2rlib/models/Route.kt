package com.getroadmap.r2rlib.models

import android.os.Parcel
import android.os.Parcelable

import java.util.ArrayList

/**
 * https://www.rome2rio.com/documentation/search#Route
 */
open class Route() : Parcelable {

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

     var name: String? = null
     var depPlace: Int? = null
     var arrPlace: Int? = null
     var distance: Float? = null
     var totalDuration: Float? = null
     var totalTransitDuration: Float? = null
     var totalTransferDuration: Float? = null
     var indicativePrices: List<IndicativePrice>? = null
     var segments: List<Segment>? = null
     var alternatives: List<Alternative>? = null

    constructor(parcel: Parcel) : this() {
        name = parcel.readString()
        depPlace = parcel.readValue(Int::class.java.classLoader) as? Int
        arrPlace = parcel.readValue(Int::class.java.classLoader) as? Int
        distance = parcel.readValue(Float::class.java.classLoader) as? Float
        totalDuration = parcel.readValue(Float::class.java.classLoader) as? Float
        totalTransitDuration = parcel.readValue(Float::class.java.classLoader) as? Float
        totalTransferDuration = parcel.readValue(Float::class.java.classLoader) as? Float
        indicativePrices = parcel.createTypedArrayList(IndicativePrice.CREATOR)
        segments = parcel.createTypedArrayList(Segment)
        alternatives = parcel.createTypedArrayList(Alternative.CREATOR)
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