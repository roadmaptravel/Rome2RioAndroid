package com.getroadmap.r2rlib.models

import android.os.Parcel
import android.os.Parcelable

import java.util.ArrayList

/**
 * Created by jan on 11/07/16.
 * https://www.rome2rio.com/documentation/search#AirLeg
 */

/**
 * operatingDays  	DayFlags 	        Days of operation bitmask (optional)
 * indicativePrices 	IndicativePrice[] 	Array of indicative prices (optional)
 * hops 	            AirHop[] 	        Array of hops
 */
data class AirLeg(val operatingDays: DayFlags?,
                  val indicativePrices: List<IndicativePrice>?,
                  val hops: List<AirHop>?) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readValue(Int::class.java.classLoader) as? DayFlags,
            parcel.createTypedArrayList(IndicativePrice),
            parcel.createTypedArrayList(AirHop)) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(operatingDays?.flag)
        parcel.writeTypedList(indicativePrices)
        parcel.writeTypedList(hops)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<AirLeg> {
        override fun createFromParcel(parcel: Parcel): AirLeg {
            return AirLeg(parcel)
        }

        override fun newArray(size: Int): Array<AirLeg?> {
            return arrayOfNulls(size)
        }
    }
}