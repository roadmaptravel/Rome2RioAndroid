package com.getroadmap.r2rlib.models

import android.os.Parcel
import android.os.Parcelable

/**
 * https://www.rome2rio.com/documentation/search#Agency
 * class for api v1.4
 */

/**
 * name 	string 	Display name
 * url 	string 	Agency URL (optional)
 * phone 	string 	Agency Phone Number (optional)
 * icon 	Icon 	Agency icon (optional)
 */
data class Agency(val name: String?,
                  val url: String?,
                  val phone: String?,
                  val icon: Icon?) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readParcelable(Icon::class.java.classLoader)) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(url)
        parcel.writeString(phone)
        parcel.writeParcelable(icon, flags)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Agency> {
        override fun createFromParcel(parcel: Parcel): Agency {
            return Agency(parcel)
        }

        override fun newArray(size: Int): Array<Agency?> {
            return arrayOfNulls(size)
        }
    }


}