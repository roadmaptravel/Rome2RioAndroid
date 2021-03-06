package com.getroadmap.r2rlib.models

import android.os.Parcel
import android.os.Parcelable

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

import java.util.ArrayList

/**
 * Created by jan on 11/07/16.
 */

/**
 * segmentKind 	    string 	"air"
 * depPlace 	        integer 	Departure airport (index into places array)
 * arrPlace 	        integer 	Arrival airport (index into places array)
 * vehicle 	        integer 	Vehicle (index into vehicles array)
 * distance 	        float 	Estimated distance (in km)
 * transitDuration 	float 	Estimated duration spent in transit (in minutes)
 * transferDuration 	float 	Estimated duration spent waiting for transfer (in minutes)
 * indicativePrices 	IndicativePrice[] 	Array of indicative prices (optional)
 *
 * outbound 	        AirLeg[] 	Array of outbound legs
 * return 	        AirLeg[] 	Array of return legs
 *
 * @return
 */
data class AirSegment(@SerializedName("outbound")
                      @Expose
                      val outbound: List<AirLeg>?,
                      @SerializedName("return")
                      @Expose
                      val returns: List<AirLeg>?) : Segment() {
    constructor(parcel: Parcel) : this(
            parcel.createTypedArrayList(AirLeg),
            parcel.createTypedArrayList(AirLeg)) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        super.writeToParcel(parcel, flags)
        parcel.writeTypedList(outbound)
        parcel.writeTypedList(returns)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<AirSegment> {
        override fun createFromParcel(parcel: Parcel): AirSegment {
            return AirSegment(parcel)
        }

        override fun newArray(size: Int): Array<AirSegment?> {
            return arrayOfNulls(size)
        }
    }
}