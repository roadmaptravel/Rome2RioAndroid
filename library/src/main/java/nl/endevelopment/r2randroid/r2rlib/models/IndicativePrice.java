package nl.endevelopment.r2randroid.r2rlib.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 *If the estimated price is a single value (not a range) then only price is returned.
 If the estimated price is a range, then both price and priceLow/priceHigh are returned.
 You can choose to display either the single price (for brevity) or the range (for accuracy).
 */
public class IndicativePrice implements Parcelable {

    /**
     name 	string 	Display name of price level (optional)
     price 	float 	Median price
     priceLow 	float 	Lower bound of price range (optional)
     priceHigh 	float 	Upper bound of price range (optional)
     currency 	string 	Currency code (ISO 4217)
     nativePrice 	float 	Median price in native currency (optional)
     nativePriceLow 	float 	Lower bound of price range in native currency (optional)
     nativePriceHigh 	float 	Upper bound of price range in native currency (optional)
     nativeCurrency 	string 	Native currency code (ISO 4217) (optional)
     */

    private String name;
    private float price;
    private float priceLow;
    private float priceHigh;
    private String currency;
    private float nativePrice;
    private float nativePriceLow;
    private float nativePriceHigh;
    private String nativeCurrency;

    public IndicativePrice() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getPriceLow() {
        return priceLow;
    }

    public void setPriceLow(float priceLow) {
        this.priceLow = priceLow;
    }

    public float getPriceHigh() {
        return priceHigh;
    }

    public void setPriceHigh(float priceHigh) {
        this.priceHigh = priceHigh;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public float getNativePrice() {
        return nativePrice;
    }

    public void setNativePrice(float nativePrice) {
        this.nativePrice = nativePrice;
    }

    public float getNativePriceLow() {
        return nativePriceLow;
    }

    public void setNativePriceLow(float nativePriceLow) {
        this.nativePriceLow = nativePriceLow;
    }

    public float getNativePriceHigh() {
        return nativePriceHigh;
    }

    public void setNativePriceHigh(float nativePriceHigh) {
        this.nativePriceHigh = nativePriceHigh;
    }

    public String getNativeCurrency() {
        return nativeCurrency;
    }

    public void setNativeCurrency(String nativeCurrency) {
        this.nativeCurrency = nativeCurrency;
    }

    protected IndicativePrice(Parcel in) {
        name = in.readString();
        price = in.readFloat();
        priceLow = in.readFloat();
        priceHigh = in.readFloat();
        currency = in.readString();
        nativePrice = in.readFloat();
        nativePriceLow = in.readFloat();
        nativePriceHigh = in.readFloat();
        nativeCurrency = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeFloat(price);
        dest.writeFloat(priceLow);
        dest.writeFloat(priceHigh);
        dest.writeString(currency);
        dest.writeFloat(nativePrice);
        dest.writeFloat(nativePriceLow);
        dest.writeFloat(nativePriceHigh);
        dest.writeString(nativeCurrency);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<IndicativePrice> CREATOR = new Parcelable.Creator<IndicativePrice>() {
        @Override
        public IndicativePrice createFromParcel(Parcel in) {
            return new IndicativePrice(in);
        }

        @Override
        public IndicativePrice[] newArray(int size) {
            return new IndicativePrice[size];
        }
    };

    @Override
    public String toString() {
        return "IndicativePrice{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", priceLow=" + priceLow +
                ", priceHigh=" + priceHigh +
                ", currency='" + currency + '\'' +
                ", nativePrice=" + nativePrice +
                ", nativePriceLow=" + nativePriceLow +
                ", nativePriceHigh=" + nativePriceHigh +
                ", nativeCurrency='" + nativeCurrency + '\'' +
                '}';
    }
}