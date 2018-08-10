package com.getroadmap.r2rlib.models

import android.os.Parcel
import android.os.Parcelable

import java.util.ArrayList

/**
 * Created by jan on 11/07/16.
 */

class AirHop() : Parcelable {

    /**
     * depPlace 	        integer 	Departure airport (index into places array)
     * arrPlace 	        integer 	Arrival airport (index into places array)
     * depTerminal 	    string 	Departure airport terminal (optional)
     * arrTerminal 	    string 	Arrivar airport terminal (optional)
     * depTime 	        string 	Departure time (24-hour local time - hh:mm)
     * arrTime 	        string 	Arrivar time (24-hour local time - hh:mm)
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

    var depPlace: Int? = null
    var arrPlace: Int? = null
    var depTerminal: String? = null
    var arrTerminal: String? = null
    var depTime: String? = null
    var arrTime: String? = null
    var flight: String? = null
    var duration: Float? = null
    var airline: String? = null
    var operatingAirline: String? = null
    var aircraft: String? = null
    var dayChange: Int? = null
    var layoverDuration: Float? = null
    var layoverDayChange: Int? = null
    var codeshares: List<AirCodeshare>? = null

    constructor(parcel: Parcel) : this() {
        depPlace = parcel.readValue(Int::class.java.classLoader) as? Int
        arrPlace = parcel.readValue(Int::class.java.classLoader) as? Int
        depTerminal = parcel.readString()
        arrTerminal = parcel.readString()
        depTime = parcel.readString()
        arrTime = parcel.readString()
        flight = parcel.readString()
        duration = parcel.readValue(Float::class.java.classLoader) as? Float
        airline = parcel.readString()
        operatingAirline = parcel.readString()
        aircraft = parcel.readString()
        dayChange = parcel.readValue(Int::class.java.classLoader) as? Int
        layoverDuration = parcel.readValue(Float::class.java.classLoader) as? Float
        layoverDayChange = parcel.readValue(Int::class.java.classLoader) as? Int
        codeshares = parcel.createTypedArrayList(AirCodeshare)
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