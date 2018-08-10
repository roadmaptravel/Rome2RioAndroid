package com.getroadmap.r2rlib.models

import android.os.Parcel
import android.os.Parcelable

/**
 * Created by jan on 08/07/16.
 * "icon": implements Parcelable {
 * "url": "/logos/trains/nl.png",
 * "x": 0,
 * "y": 0,
 * "w": 27,
 * "h": 23
 * }
 */

open class Icon() : Parcelable {
    private var url: String? = null
    private var x: Int? = null
    private var y: Int? = null
    private var w: Int? = null
    private var h: Int? = null

    constructor(parcel: Parcel) : this() {
        url = parcel.readString()
        x = parcel.readValue(Int::class.java.classLoader) as? Int
        y = parcel.readValue(Int::class.java.classLoader) as? Int
        w = parcel.readValue(Int::class.java.classLoader) as? Int
        h = parcel.readValue(Int::class.java.classLoader) as? Int
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(url)
        parcel.writeValue(x)
        parcel.writeValue(y)
        parcel.writeValue(w)
        parcel.writeValue(h)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Icon> {
        override fun createFromParcel(parcel: Parcel): Icon {
            return Icon(parcel)
        }

        override fun newArray(size: Int): Array<Icon?> {
            return arrayOfNulls(size)
        }
    }

}