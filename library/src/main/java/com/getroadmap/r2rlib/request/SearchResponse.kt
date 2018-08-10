package com.getroadmap.r2rlib.request

import android.os.Parcel
import android.os.Parcelable

import java.util.ArrayList

import com.getroadmap.r2rlib.models.Agency
import com.getroadmap.r2rlib.models.Aircraft
import com.getroadmap.r2rlib.models.Airline
import com.getroadmap.r2rlib.models.Place
import com.getroadmap.r2rlib.models.Route
import com.getroadmap.r2rlib.models.Vehicle

/**
 * elapsedTime 	string 	    Time to process request (in milliseconds)
 * currencyCode 	string 	    Response currency code (ISO 4217)
 * languageCode 	string 	    Response language code (ISO 639-1)
 * data 	        string 	    Caller supplied data string (optional)
 * places 	    Place[] 	Array of places [1]
 * airlines 	    Airline[] 	Array of airlines
 * aircrafts 	    Aircraft[] 	Array of aircrafts
 * agencies 	    Agency[] 	Array of transit agencies
 * vehicles 	    Vehicle[] 	Array of transit vehicles
 * routes
 */
data class SearchResponse(
        val elapsedTime: String?,
        val currencyCode: String?,
        val languageCode: String?,
        val data: String?,
        val places: List<Place>?,
        val airlines: List<Airline>?,
        val aircrafts: List<Aircraft>?,
        val agencies: List<Agency>?,
        val routes: List<Route>?,
        val vehicles: List<Vehicle>?
) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.createTypedArrayList(Place),
            parcel.createTypedArrayList(Airline),
            parcel.createTypedArrayList(Aircraft),
            parcel.createTypedArrayList(Agency),
            parcel.createTypedArrayList(Route),
            parcel.createTypedArrayList(Vehicle)) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(elapsedTime)
        parcel.writeString(currencyCode)
        parcel.writeString(languageCode)
        parcel.writeString(data)
        parcel.writeTypedList(places)
        parcel.writeTypedList(airlines)
        parcel.writeTypedList(aircrafts)
        parcel.writeTypedList(agencies)
        parcel.writeTypedList(routes)
        parcel.writeTypedList(vehicles)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<SearchResponse> {
        override fun createFromParcel(parcel: Parcel): SearchResponse {
            return SearchResponse(parcel)
        }

        override fun newArray(size: Int): Array<SearchResponse?> {
            return arrayOfNulls(size)
        }
    }
}