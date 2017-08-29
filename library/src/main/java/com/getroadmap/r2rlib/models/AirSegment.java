package com.getroadmap.r2rlib.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jan on 11/07/16.
 */

public class AirSegment extends Segment implements Parcelable {

    /**
     * segmentKind 	    string 	"air"
     * depPlace 	        integer 	Departure airport (index into places array)
     * arrPlace 	        integer 	Arrival airport (index into places array)
     * vehicle 	        integer 	Vehicle (index into vehicles array)
     * distance 	        float 	Estimated distance (in km)
     * transitDuration 	float 	Estimated duration spent in transit (in minutes)
     * transferDuration 	float 	Estimated duration spent waiting for transfer (in minutes)
     * indicativePrices 	IndicativePrice[] 	Array of indicative prices (optional)
     *
     * outbound 	        AirLeg[] 	Array of outbound legs
     * return 	        AirLeg[] 	Array of return legs
     *
     * @return
     */

    @SerializedName("outbound")
    @Expose
    private List<AirLeg> outbound = null;
    @SerializedName("return")
    @Expose
    private List<AirLeg> returns = null;

    public AirSegment() {
    }

    public List<AirLeg> getOutbound() {
        return outbound;
    }

    public void setOutbound(List<AirLeg> outbound) {
        this.outbound = outbound;
    }

    public List<AirLeg> getReturns() {
        return returns;
    }

    public void setReturns(List<AirLeg> returns) {
        this.returns = returns;
    }

    protected AirSegment(Parcel in) {
        if (in.readByte() == 0x01) {
            outbound = new ArrayList<AirLeg>();
            in.readList(outbound, AirLeg.class.getClassLoader());
        } else {
            outbound = null;
        }
        if (in.readByte() == 0x01) {
            returns = new ArrayList<AirLeg>();
            in.readList(returns, AirLeg.class.getClassLoader());
        } else {
            returns = null;
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (outbound == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(outbound);
        }
        if (returns == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(returns);
        }
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<AirSegment> CREATOR = new Parcelable.Creator<AirSegment>() {
        @Override
        public AirSegment createFromParcel(Parcel in) {
            return new AirSegment(in);
        }

        @Override
        public AirSegment[] newArray(int size) {
            return new AirSegment[size];
        }
    };

    @Override
    public String toString() {
        return "AirSegment{" +
                "outbound=" + outbound +
                ", returns=" + returns +
                '}';
    }
}