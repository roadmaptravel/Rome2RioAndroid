package com.getroadmap.r2rlib.models

import android.os.Parcel
import android.os.Parcelable

/**
 * Created by jan on 11/07/16.
 */

/**
 * text 	        string 	Link text
 * url 	        string 	Link URL
 * displayUrl 	string 	Display URL (cleaned up link url) (optional)
 * moustacheUrl 	string 	Moustach URL (link url with replacement parameters) (optional)
 */

data class ExternalLink(val text: String?,
                        val url: String?,
                        val displayUrl: String?,
                        val moustacheUrl: String?) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(text)
        parcel.writeString(url)
        parcel.writeString(displayUrl)
        parcel.writeString(moustacheUrl)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ExternalLink> {
        override fun createFromParcel(parcel: Parcel): ExternalLink {
            return ExternalLink(parcel)
        }

        override fun newArray(size: Int): Array<ExternalLink?> {
            return arrayOfNulls(size)
        }
    }
}