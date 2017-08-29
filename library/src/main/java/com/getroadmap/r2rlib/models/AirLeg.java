package com.getroadmap.r2rlib.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jan on 11/07/16.
 * https://www.rome2rio.com/documentation/search#AirLeg
 */

public class AirLeg implements Parcelable {
    /**
     operatingDays  	DayFlags 	        Days of operation bitmask (optional)
     indicativePrices 	IndicativePrice[] 	Array of indicative prices (optional)
     hops 	            AirHop[] 	        Array of hops
     */

    private DayFlags operatingDays;
    private List<IndicativePrice> indicativePrices;
    private List<AirHop> hops;

    public AirLeg() {
    }

    public DayFlags getOperatingDays() {
        return operatingDays;
    }

    public void setOperatingDays(DayFlags operatingDays) {
        this.operatingDays = operatingDays;
    }

    public List<IndicativePrice> getIndicativePrices() {
        return indicativePrices;
    }

    public void setIndicativePrices(List<IndicativePrice> indicativePrices) {
        this.indicativePrices = indicativePrices;
    }

    public List<AirHop> getHops() {
        return hops;
    }

    public void setHops(List<AirHop> hops) {
        this.hops = hops;
    }

    protected AirLeg(Parcel in) {
        operatingDays = (DayFlags) in.readValue(DayFlags.class.getClassLoader());
        if (in.readByte() == 0x01) {
            indicativePrices = new ArrayList<IndicativePrice>();
            in.readList(indicativePrices, IndicativePrice.class.getClassLoader());
        } else {
            indicativePrices = null;
        }
        if (in.readByte() == 0x01) {
            hops = new ArrayList<AirHop>();
            in.readList(hops, AirHop.class.getClassLoader());
        } else {
            hops = null;
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(operatingDays);
        if (indicativePrices == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(indicativePrices);
        }
        if (hops == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(hops);
        }
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<AirLeg> CREATOR = new Parcelable.Creator<AirLeg>() {
        @Override
        public AirLeg createFromParcel(Parcel in) {
            return new AirLeg(in);
        }

        @Override
        public AirLeg[] newArray(int size) {
            return new AirLeg[size];
        }
    };

    @Override
    public String toString() {
        return "AirLeg{" +
                "operatingDays=" + operatingDays +
                ", indicativePrices=" + indicativePrices +
                ", hops=" + hops +
                '}';
    }
}