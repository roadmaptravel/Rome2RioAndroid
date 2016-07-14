package nl.endevelopment.r2randroid.r2rlib.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * https://www.rome2rio.com/documentation/search#Segment
 */
public class Segment implements Parcelable {

    /**
     segmentKind 	string 	"air"
     depPlace 	integer 	Departure airport (index into places array)
     arrPlace 	integer 	Arrival airport (index into places array)
     vehicle 	integer 	Vehicle (index into vehicles array)
     distance 	float 	Estimated distance (in km)
     transitDuration 	float 	Estimated duration spent in transit (in minutes)
     transferDuration 	float 	Estimated duration spent waiting for transfer (in minutes)
     indicativePrices 	IndicativePrice[] 	Array of indicative prices (optional)
     outbound 	AirLeg[] 	Array of outbound legs
     return 	AirLeg[] 	Array of return legs
     */

    private String segmentKind; //e.g. "air"
    private int depPlace; //Departure airport (index into places array)
    private int arrPlace; //Arrival airport (index into places array)
    private int vehicle;  //Vehicle (index into vehicles array)
    private float distance; //Estimated distance (in km)
    private float transitDuration;//Estimated duration spent in transit (in minutes)
    private float transferDuration; //Estimated duration spent waiting for transfer (in minutes)
    private List<IndicativePrice> indicativePrices; //IndicativePrice[] 	Array of indicative prices (optional)
    private List<AirLeg> outbound; //Array of outbound legs
    @SerializedName("return")
    private List<AirLeg> returnLegs;  //Array of return legs

    public Segment() {
    }

    public String getSegmentKind() {
        return segmentKind;
    }

    public void setSegmentKind(String segmentKind) {
        this.segmentKind = segmentKind;
    }

    public int getDepPlace() {
        return depPlace;
    }

    public void setDepPlace(int depPlace) {
        this.depPlace = depPlace;
    }

    public int getArrPlace() {
        return arrPlace;
    }

    public void setArrPlace(int arrPlace) {
        this.arrPlace = arrPlace;
    }

    public int getVehicle() {
        return vehicle;
    }

    public void setVehicle(int vehicle) {
        this.vehicle = vehicle;
    }

    public float getDistance() {
        return distance;
    }

    public void setDistance(float distance) {
        this.distance = distance;
    }

    public float getTransitDuration() {
        return transitDuration;
    }

    public void setTransitDuration(float transitDuration) {
        this.transitDuration = transitDuration;
    }

    public float getTransferDuration() {
        return transferDuration;
    }

    public void setTransferDuration(float transferDuration) {
        this.transferDuration = transferDuration;
    }

    public List<IndicativePrice> getIndicativePrices() {
        return indicativePrices;
    }

    public void setIndicativePrices(List<IndicativePrice> indicativePrices) {
        this.indicativePrices = indicativePrices;
    }

    public List<AirLeg> getOutbound() {
        return outbound;
    }

    public void setOutbound(List<AirLeg> outbound) {
        this.outbound = outbound;
    }

    public List<AirLeg> getReturnLegs() {
        return returnLegs;
    }

    public void setReturnLegs(List<AirLeg> returnLegs) {
        this.returnLegs = returnLegs;
    }

    protected Segment(Parcel in) {
        segmentKind = in.readString();
        depPlace = in.readInt();
        arrPlace = in.readInt();
        vehicle = in.readInt();
        distance = in.readFloat();
        transitDuration = in.readFloat();
        transferDuration = in.readFloat();
        if (in.readByte() == 0x01) {
            indicativePrices = new ArrayList<IndicativePrice>();
            in.readList(indicativePrices, IndicativePrice.class.getClassLoader());
        } else {
            indicativePrices = null;
        }
        if (in.readByte() == 0x01) {
            outbound = new ArrayList<AirLeg>();
            in.readList(outbound, AirLeg.class.getClassLoader());
        } else {
            outbound = null;
        }
        if (in.readByte() == 0x01) {
            returnLegs = new ArrayList<AirLeg>();
            in.readList(returnLegs, AirLeg.class.getClassLoader());
        } else {
            returnLegs = null;
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(segmentKind);
        dest.writeInt(depPlace);
        dest.writeInt(arrPlace);
        dest.writeInt(vehicle);
        dest.writeFloat(distance);
        dest.writeFloat(transitDuration);
        dest.writeFloat(transferDuration);
        if (indicativePrices == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(indicativePrices);
        }
        if (outbound == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(outbound);
        }
        if (returnLegs == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(returnLegs);
        }
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Segment> CREATOR = new Parcelable.Creator<Segment>() {
        @Override
        public Segment createFromParcel(Parcel in) {
            return new Segment(in);
        }

        @Override
        public Segment[] newArray(int size) {
            return new Segment[size];
        }
    };
}