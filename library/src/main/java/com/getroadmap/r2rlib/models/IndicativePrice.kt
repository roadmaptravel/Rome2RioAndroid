package com.getroadmap.r2rlib.models

import android.os.Parcel
import android.os.Parcelable

/**
 * If the estimated price is a single value (not a range) then only price is returned.
 * If the estimated price is a range, then both price and priceLow/priceHigh are returned.
 * You can choose to display either the single price (for brevity) or the range (for accuracy).
 */

/**
 * name 	string 	Display name of price level (optional)
 * price 	float 	Median price
 * priceLow 	float 	Lower bound of price range (optional)
 * priceHigh 	float 	Upper bound of price range (optional)
 * currency 	string 	Currency code (ISO 4217)
 * nativePrice 	float 	Median price in native currency (optional)
 * nativePriceLow 	float 	Lower bound of price range in native currency (optional)
 * nativePriceHigh 	float 	Upper bound of price range in native currency (optional)
 * nativeCurrency 	string 	Native currency code (ISO 4217) (optional)
 */
data class IndicativePrice(val name: String?,
                           val price: Float?,
                           val priceLow: Float?,
                           val priceHigh: Float?,
                           val currency: String?,
                           val nativePrice: Float?,
                           val nativePriceLow: Float?,
                           val nativePriceHigh: Float?,
                           val nativeCurrency: String?) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readValue(Float::class.java.classLoader) as? Float,
            parcel.readValue(Float::class.java.classLoader) as? Float,
            parcel.readValue(Float::class.java.classLoader) as? Float,
            parcel.readString(),
            parcel.readValue(Float::class.java.classLoader) as? Float,
            parcel.readValue(Float::class.java.classLoader) as? Float,
            parcel.readValue(Float::class.java.classLoader) as? Float,
            parcel.readString()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeValue(price)
        parcel.writeValue(priceLow)
        parcel.writeValue(priceHigh)
        parcel.writeString(currency)
        parcel.writeValue(nativePrice)
        parcel.writeValue(nativePriceLow)
        parcel.writeValue(nativePriceHigh)
        parcel.writeString(nativeCurrency)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<IndicativePrice> {
        override fun createFromParcel(parcel: Parcel): IndicativePrice {
            return IndicativePrice(parcel)
        }

        override fun newArray(size: Int): Array<IndicativePrice?> {
            return arrayOfNulls(size)
        }
    }


}