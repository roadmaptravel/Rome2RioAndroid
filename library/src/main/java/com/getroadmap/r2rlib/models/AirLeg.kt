package com.getroadmap.r2rlib.models

import android.os.Parcel
import android.os.Parcelable

import java.util.ArrayList

/**
 * Created by jan on 11/07/16.
 * https://www.rome2rio.com/documentation/search#AirLeg
 */

open class AirLeg() : Parcelable {
    /**
     * operatingDays  	DayFlags 	        Days of operation bitmask (optional)
     * indicativePrices 	IndicativePrice[] 	Array of indicative prices (optional)
     * hops 	            AirHop[] 	        Array of hops
     */

     var operatingDays: DayFlags? = null
     var indicativePrices: List<IndicativePrice>? = null
     var hops: List<AirHop>? = null

    constructor(parcel: Parcel) : this() {
        indicativePrices = parcel.createTypedArrayList(IndicativePrice.CREATOR)
        hops = parcel.createTypedArrayList(AirHop.CREATOR)
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
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