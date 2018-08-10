package com.getroadmap.r2rlib.models

import android.os.Parcel
import android.os.Parcelable

import java.util.ArrayList

/**
 * Created by jan on 11/07/16.
 */

/**
 * depPlace 	        integer 	Departure airport (index into places array)
 * arrPlace 	        integer 	Arrival airport (index into places array)
 * depTerminal 	    string 	Departure airport terminal (optional)
 * arrTerminal 	    string 	Arrival airport terminal (optional)
 * depTime 	        string 	Departure time (24-hour local time - hh:mm)
 * arrTime 	        string 	Arrival time (24-hour local time - hh:mm)
 * flight 	        string 	Flight number
 * duration 	        float 	Estimated flight duration (in minutes)
 * airline 	        string 	Advertised airline (index into airlines array)
 * operatingAirline 	string 	Operating airline (index into airlines array) (optional)
 * aircraft 	        string 	Aircraft (index into aircrafts array) (optional)
 * dayChange 	        integer 	Num day changes during flight (optional)
 * layoverDuration 	float 	Layover time (in minutes) (optional)
 * layoverDayChange 	integer 	Num day changes during layover (optional)
 * codeshares 	    AirCodeshare[] 	Array of codeshares (optional)
 */
data class AirHop(val depPlace: Int?,
                  val arrPlace: Int?,
                  val depTerminal: String?,
                  val arrTerminal: String?,
                  val depTime: String?,
                  val arrTime: String?,
                  val flight: String?,
                  val duration: Float?,
                  val airline: String?,
                  val operatingAirline: String?,
                  val aircraft: String?,
                  val dayChange: Int?,
                  val layoverDuration: Float?,
                  val layoverDayChange: Int?,
                  val codeshares: List<AirCodeshare>?) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readValue(Int::class.java.classLoader) as? Int,
            parcel.readValue(Int::class.java.classLoader) as? Int,
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readValue(Float::class.java.classLoader) as? Float,
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readValue(Int::class.java.classLoader) as? Int,
            parcel.readValue(Float::class.java.classLoader) as? Float,
            parcel.readValue(Int::class.java.classLoader) as? Int,
            parcel.createTypedArrayList(AirCodeshare)) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(depPlace)
        parcel.writeValue(arrPlace)
        parcel.writeString(depTerminal)
        parcel.writeString(arrTerminal)
        parcel.writeString(depTime)
        parcel.writeString(arrTime)
        parcel.writeString(flight)
        parcel.writeValue(duration)
        parcel.writeString(airline)
        parcel.writeString(operatingAirline)
        parcel.writeString(aircraft)
        parcel.writeValue(dayChange)
        parcel.writeValue(layoverDuration)
        parcel.writeValue(layoverDayChange)
        parcel.writeTypedList(codeshares)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<AirHop> {
        override fun createFromParcel(parcel: Parcel): AirHop {
            return AirHop(parcel)
        }

        override fun newArray(size: Int): Array<AirHop?> {
            return arrayOfNulls(size)
        }
    }
}