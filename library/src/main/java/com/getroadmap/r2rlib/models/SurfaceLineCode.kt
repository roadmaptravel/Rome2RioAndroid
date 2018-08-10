package com.getroadmap.r2rlib.models

import android.os.Parcel
import android.os.Parcelable

/**
 * Created by jan on 11/07/16.
 */

class SurfaceLineCode() : Parcelable {
    var code: String? = null // 	Internal line code

    constructor(parcel: Parcel) : this() {
        code = parcel.readString()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(code)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<SurfaceLineCode> {
        override fun createFromParcel(parcel: Parcel): SurfaceLineCode {
            return SurfaceLineCode(parcel)
        }

        override fun newArray(size: Int): Array<SurfaceLineCode?> {
            return arrayOfNulls(size)
        }
    }

}