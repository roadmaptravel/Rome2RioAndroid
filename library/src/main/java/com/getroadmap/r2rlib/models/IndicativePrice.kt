package com.getroadmap.r2rlib.models

import android.os.Parcel
import android.os.Parcelable

/**
 * If the estimated price is a single value (not a range) then only price is returned.
 * If the estimated price is a range, then both price and priceLow/priceHigh are returned.
 * You can choose to display either the single price (for brevity) or the range (for accuracy).
 */
open class IndicativePrice() : Parcelable {

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

    var name: String? = null
    var price: Float? = null
    var priceLow: Float? = null
    var priceHigh: Float? = null
    var currency: String? = null
    var nativePrice: Float? = null
    var nativePriceLow: Float? = null
    var nativePriceHigh: Float? = null
    var nativeCurrency: String? = null

    constructor(parcel: Parcel) : this() {
        name = parcel.readString()
        price = parcel.readValue(Float::class.java.classLoader) as? Float
        priceLow = parcel.readValue(Float::class.java.classLoader) as? Float
        priceHigh = parcel.readValue(Float::class.java.classLoader) as? Float
        currency = parcel.readString()
        nativePrice = parcel.readValue(Float::class.java.classLoader) as? Float
        nativePriceLow = parcel.readValue(Float::class.java.classLoader) as? Float
        nativePriceHigh = parcel.readValue(Float::class.java.classLoader) as? Float
        nativeCurrency = parcel.readString()
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