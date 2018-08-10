package com.getroadmap.r2rlib.models

import android.os.Parcel
import android.os.Parcelable

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

import java.util.ArrayList

/**
 * https://www.rome2rio.com/documentation/search#Segment
 */
open class Segment() : Parcelable {

    /**
     * segmentKind	string	Segment kind [1]
     * depPlace	integer	Departure airport (index into places array)
     * arrPlace	integer	Arrival airport (index into places array)
     * vehicle	integer	Vehicle (index into vehicles array)
     * distance	float	Estimated distance (in km)
     * transitDuration	float	Estimated duration spent in transit (in minutes)
     * transferDuration	float	Estimated duration spent waiting for transfer (in minutes)
     * indicativePrices	IndicativePrice[]	Array of indicative prices (optional)
     */

    @SerializedName("segmentKind")
    @Expose
    var segmentKind: String? = null //e.g. "air"
    @SerializedName("depPlace")
    @Expose
    var depPlace: Int? = null//Departure airport (index into places array)
    @SerializedName("arrPlace")
    @Expose
    var arrPlace: Int? = null//Arrival airport (index into places array)
    @SerializedName("vehicle")
    @Expose
    var vehicle: Int? = null//Vehicle (index into vehicles array)
    @SerializedName("distance")
    @Expose
    var distance: Float? = null//Estimated distance (in km)
    @SerializedName("transitDuration")
    @Expose
    var transitDuration: Float? = null//Estimated duration spent in transit (in minutes)
    @SerializedName("transferDuration")
    @Expose
    var transferDuration: Float? = null//Estimated duration spent waiting for transfer (in minutes)
    @SerializedName("indicativePrices")
    @Expose
    var indicativePrices: List<IndicativePrice>? = null//IndicativePrice[] 	Array of indicative prices (optional)

    constructor(parcel: Parcel) : this() {
        segmentKind = parcel.readString()
        depPlace = parcel.readValue(Int::class.java.classLoader) as? Int
        arrPlace = parcel.readValue(Int::class.java.classLoader) as? Int
        vehicle = parcel.readValue(Int::class.java.classLoader) as? Int
        distance = parcel.readValue(Float::class.java.classLoader) as? Float
        transitDuration = parcel.readValue(Float::class.java.classLoader) as? Float
        transferDuration = parcel.readValue(Float::class.java.classLoader) as? Float
        indicativePrices = parcel.createTypedArrayList(IndicativePrice.CREATOR)
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(segmentKind)
        parcel.writeValue(depPlace)
        parcel.writeValue(arrPlace)
        parcel.writeValue(vehicle)
        parcel.writeValue(distance)
        parcel.writeValue(transitDuration)
        parcel.writeValue(transferDuration)
        parcel.writeTypedList(indicativePrices)
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun toString(): String {
        return "Segment(segmentKind=$segmentKind, depPlace=$depPlace, arrPlace=$arrPlace, vehicle=$vehicle, distance=$distance, transitDuration=$transitDuration, transferDuration=$transferDuration, indicativePrices=$indicativePrices)"
    }

    companion object CREATOR : Parcelable.Creator<Segment> {
        override fun createFromParcel(parcel: Parcel): Segment {
            return Segment(parcel)
        }

        override fun newArray(size: Int): Array<Segment?> {
            return arrayOfNulls(size)
        }
    }




}