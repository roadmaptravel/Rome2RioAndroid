package com.getroadmap.r2rlib.models

import android.os.Parcel
import android.os.Parcelable

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

import com.getroadmap.r2rlib.enums.PlaceKind

/**
 * Created by Jan on 23-09-17.
 * class for api v1.4
 * https://www.rome2rio.com/documentation/search#Place
 */


/**
 * lat 	    float 	Latitude (WGS84)
 * lng 	    float 	Longitude (WGS84)
 * kind 	    string 	Type of place [1]
 * shortName 	string 	Display name
 * code 	    string 	Airport or Station code (eg: IATA)
 * regionCode string 	Region code (ISO 3166-2 or FIPS) (optional)
 * countryCodestring 	Country code (ISO 3166-1 alpha-2) (optional)
 * timeZone 	string 	Time zone (IANA) (optional)
 */
data class Place(@SerializedName("lat")
                 @Expose
                 var lat: Float?,
                 @SerializedName("lng")
                 @Expose
                 var lng: Float?,
                 @SerializedName("kind")
                 @Expose
                 var kind: String?,
                 @SerializedName("shortName")
                 @Expose
                 var shortName: String?,
                 @SerializedName("longName")
                 @Expose
                 var longName: String?,
                 @SerializedName("canonicalName")
                 @Expose
                 var canonicalName: String?,
                 @SerializedName("regionCode")
                 @Expose
                 var regionCode: String?,
                 @SerializedName("countryCode")
                 @Expose
                 var countryCode: String?,
                 @SerializedName("timeZone")
                 @Expose
                 var timeZone: String?,
                 @SerializedName("code")
                 @Expose
                 var code: String?) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readValue(Float::class.java.classLoader) as? Float,
            parcel.readValue(Float::class.java.classLoader) as? Float,
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(lat)
        parcel.writeValue(lng)
        parcel.writeString(kind)
        parcel.writeString(shortName)
        parcel.writeString(longName)
        parcel.writeString(canonicalName)
        parcel.writeString(regionCode)
        parcel.writeString(countryCode)
        parcel.writeString(timeZone)
        parcel.writeString(code)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Place> {
        override fun createFromParcel(parcel: Parcel): Place {
            return Place(parcel)
        }

        override fun newArray(size: Int): Array<Place?> {
            return arrayOfNulls(size)
        }
    }


}