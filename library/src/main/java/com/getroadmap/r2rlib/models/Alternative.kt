package com.getroadmap.r2rlib.models

import android.os.Parcel
import android.os.Parcelable

/**
 * Created by jan on 11/07/16.
 *
 * https://www.rome2rio.com/documentation/search#Alternative
 */

open class Alternative() : Parcelable {
    /**
     * firstSegment 	integer 	First segment to replace (index into segments array) [1]
     * lastSegment 	integer 	Last segment to replace (index into segments array) [1]
     * route 	        Route 	    Alternative route
     */

    private var firstSegment: Int? = null
    private var lastSegment: Int? = null
    private var route: Route? = null

    constructor(parcel: Parcel) : this() {
        firstSegment = parcel.readValue(Int::class.java.classLoader) as? Int
        lastSegment = parcel.readValue(Int::class.java.classLoader) as? Int
        route = parcel.readParcelable(Route::class.java.classLoader)
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(firstSegment)
        parcel.writeValue(lastSegment)
        parcel.writeParcelable(route, flags)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Alternative> {
        override fun createFromParcel(parcel: Parcel): Alternative {
            return Alternative(parcel)
        }

        override fun newArray(size: Int): Array<Alternative?> {
            return arrayOfNulls(size)
        }
    }

}