package com.getroadmap.r2rlib.models

import android.os.Parcel
import android.os.Parcelable

/**
 * Created by Glenn on 09-07-15.
 *
 * https://www.rome2rio.com/documentation/search#Aircraft
 * class for api v1.4
 */
class Aircraft() : Parcelable {

    /**
     * code 	        string 	Aircraft code (IATA)
     * manufacturer 	string 	Manufacturer name
     * model 	        string 	Model name
     */

    var code: String? = null
    var manufacturer: String? = null
    var model: String? = null

    constructor(parcel: Parcel) : this() {
        code = parcel.readString()
        manufacturer = parcel.readString()
        model = parcel.readString()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(code)
        parcel.writeString(manufacturer)
        parcel.writeString(model)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Aircraft> {
        override fun createFromParcel(parcel: Parcel): Aircraft {
            return Aircraft(parcel)
        }

        override fun newArray(size: Int): Array<Aircraft?> {
            return arrayOfNulls(size)
        }
    }

}
